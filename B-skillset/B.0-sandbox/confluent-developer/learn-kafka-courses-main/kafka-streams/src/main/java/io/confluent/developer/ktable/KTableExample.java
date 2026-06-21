package io.confluent.developer.ktable;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.KeyValueStore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class KTableExample {

    public static void main(String[] args) throws IOException {
        final Properties streamsProps = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/streams.properties")) {
            streamsProps.load(fis);
        }
        streamsProps.put(StreamsConfig.APPLICATION_ID_CONFIG, "ktable-application");

        StreamsBuilder builder = new StreamsBuilder();
        final String inputTopic = streamsProps.getProperty("ktable.input.topic");
        final String outputTopic = streamsProps.getProperty("ktable.output.topic");

        // Start by creating a variable to store the string that we want to filter on:
        final String orderNumberStart = "orderNumber-";

        // Crate a table with the StreamBuilder from above and use the table method
        // along with the inputTopic create a Materialized instance and name the store
        // and provide a Serdes for the key and the value  HINT: Materialized.<String, String, KeyValueStore<Bytes, byte[]>>as
        // then use two methods to specify the key and value serde
        KTable<String, String> firstKTable = builder.table(
                inputTopic,
                Materialized.<String, String, KeyValueStore<Bytes, byte[]>>as("ktable-store")
                    // Add SerDes for the key and value on your Materialized object:
                    .withKeySerde(Serdes.String())
                    .withValueSerde(Serdes.String())
        );

        // Add a filter operator for removing records that don't contain the order number variable value:
        firstKTable.filter((key, value) -> value.contains(orderNumberStart))
                // Map the values by taking a substring:
                .mapValues(value -> value.substring(value.indexOf("-") + 1))
                // Then filter again by taking out records where the number value of the string is less than or equal to 1000:
                .filter((key, value) -> Long.parseLong(value) > 1000)
                // Add a method here to covert the table to a stream
                .toStream()
                // Then uncomment the following two lines to view results on the console and write to a topic
                // Add a peek operation to view the key values from the table:
                .peek((key, value) -> System.out.println("Outgoing record - key " +key +" value " + value))
                // Write the records to a topic:
                .to(outputTopic, Produced.with(Serdes.String(), Serdes.String()));

        // Create a KafkaStreams object and run the topic data helper utility:
        try (KafkaStreams kafkaStreams = new KafkaStreams(builder.build(), streamsProps)) {
            final CountDownLatch shutdownLatch = new CountDownLatch(1);

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                kafkaStreams.close(Duration.ofSeconds(2));
                shutdownLatch.countDown();
            }));
            TopicLoader.runProducer();
            try {
                // kafkaStreams.start();
                kafkaStreams.start();
                shutdownLatch.await();
            } catch (Throwable e) {
                System.exit(1);
            }
        }
        System.exit(0);
    }
}
