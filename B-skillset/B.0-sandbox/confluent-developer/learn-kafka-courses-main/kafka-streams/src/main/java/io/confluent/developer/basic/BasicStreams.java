package io.confluent.developer.basic;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class BasicStreams {

    public static void main(String[] args) throws IOException {

        // Create a properties object.
        Properties streamsProps = new Properties();

        // Make sure you've added your Confluent Cloud credentials as outlined in the README
        // Use a `FileInputStream` to load properties from the file that includes your Confluent Cloud properties; in addition, add the application configuration ID to the properties:
        try (FileInputStream fis = new FileInputStream("src/main/resources/streams.properties")) {
            streamsProps.load(fis);
        }
        streamsProps.put(StreamsConfig.APPLICATION_ID_CONFIG, "basic-streams");

        // Create a `StreamsBuilder` instance, and retrieve the name of the `inputTopic` and `outputTopic` from the `Properties`:
        StreamsBuilder builder = new StreamsBuilder();
        final String inputTopic = streamsProps.getProperty("basic.input.topic");
        final String outputTopic = streamsProps.getProperty("basic.output.topic");

        // Create an order number variable (you'll see where it comes into play soon), and then create the KStream instance (note the use of the `inputTopic` variable):
        final String orderNumberStart = "orderNumber-";
        // Using the StreamsBuilder from above, create a KStream with an input-topic
        // and a Consumed instance with the correct
        // Serdes for the key and value HINT: builder.stream and Serdes.String()
//        KStream<String, String> firstStream = null;
        KStream<String, String> firstStream = builder.stream(
                inputTopic,
                Consumed.with(
                        Serdes.String(),
                        Serdes.String()
                )
        );

        // Add a peek operator (it's expected that you don't modify the keys and values). Here, it's printing records as they come into the topology:
        firstStream.peek((key, value) -> System.out.println("Incoming record - key " + key + " value " + value))
                // filter records by making sure they contain the orderNumberStart variable from above HINT: use filter
                // map the value to a new string by removing the orderNumberStart portion HINT: use mapValues
                // only forward records where the value is 1000 or greater HINT: use filter and Long.parseLong
                .peek((key, value) -> System.out.println("Outgoing record - key " + key + " value " + value))
                // Write the results to an output topic defined above as outputTopic HINT: use "to" and Produced and Serdes.String()

                // Add a filter to drop records where the value doesn't contain an order number string:
                .filter((key, value) -> value.contains(orderNumberStart))

                // Add a mapValues operation to extract the number after the dash:
                .mapValues(value -> value.substring(value.indexOf("-") + 1))

                // Add another filter to drop records where the value is not greater than 1000:
                .filter((key, value) -> Long.parseLong(value) > 1000)

                // Add an additional peek method to display the transformed records:
                .peek((key, value) -> System.out.println("Outgoing record - key " + key + " value " + value))

                // Add the to operator, the processor that writes records to a topic:
                .to(outputTopic, Produced.with(Serdes.String(), Serdes.String()));

        // Create the Kafka Streams instance:
        try (KafkaStreams kafkaStreams = new KafkaStreams(builder.build(), streamsProps)) {
            final CountDownLatch shutdownLatch = new CountDownLatch(1);

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                kafkaStreams.close(Duration.ofSeconds(2));
                shutdownLatch.countDown();
            }));

            // Use the utility method `TopicLoader.runProducer()` to create the required topics on the cluster and produce some sample records (we’ll see this pattern throughout the exercises, but keep in mind that it's not part of a standard Kafka Streams application):
            TopicLoader.runProducer();

            try {
                // Start the application:
                kafkaStreams.start();
                shutdownLatch.await();
            } catch (Throwable e) {
                System.exit(1);
            }
        }
        System.exit(0);
    }
}

