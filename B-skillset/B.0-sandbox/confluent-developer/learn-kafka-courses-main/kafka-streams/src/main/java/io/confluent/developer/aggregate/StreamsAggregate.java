package io.confluent.developer.aggregate;

import io.confluent.developer.StreamsUtils;
import io.confluent.developer.avro.ElectronicOrder;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class StreamsAggregate {

    public static void main(String[] args) throws IOException {

        final Properties streamsProps = StreamsUtils.loadProperties();
        streamsProps.put(StreamsConfig.APPLICATION_ID_CONFIG, "aggregate-streams");

        StreamsBuilder builder = new StreamsBuilder();

        // To begin, let’s extract the names of the topics from the configuration, which we’ve already loaded via a static helper method. Then we’ll convert the properties to a HashMap and use another utility method to create the specific record AvroSerde.
        final String inputTopic = streamsProps.getProperty("aggregate.input.topic");
        final String outputTopic = streamsProps.getProperty("aggregate.output.topic");
        final Map<String, Object> configMap = StreamsUtils.propertiesToMap(streamsProps);

        final SpecificAvroSerde<ElectronicOrder> electronicSerde =
                StreamsUtils.getSpecificAvroSerde(configMap);

        // Create the electronic orders stream:
        final KStream<String, ElectronicOrder> electronicStream =
                builder.stream(inputTopic, Consumed.with(Serdes.String(), electronicSerde))
                        .peek((key, value) -> System.out.println("Incoming record - key " + key + " value " + value));

        // Now take the electronicStream object, group by key and perform an aggregation
        // Don't forget to convert the KTable returned by the aggregate call back to a KStream using the toStream method
        electronicStream.groupByKey().aggregate(() -> 0.0,
                // Now add the aggregator implementation, which takes each order and adds the price to a running total, a sum of all electronic orders. Also add a Materialized, which is necessary to provide state store SerDes since the value type has changed.
                (key, order, total) -> total + order.getPrice(), Materialized.with(Serdes.String(), Serdes.Double())
        )
                // Call toStream() on the KTable that results from the aggregation operation, add a peek operation to print the results of the aggregation, and then add a .to operator to write the results to a topic:
                .toStream()
                // To view the results of the aggregation consider
                // right after the toStream() method .peek((key, value) -> System.out.println("Outgoing record - key " +key +" value " + value))
                .peek((key, value) -> System.out.println("Outgoing record - key " +key +" value " + value))
                // Finally write the results to an output topic
                //  .to(outputTopic, Produced.with(Serdes.String(), Serdes.Double()));
                .to(outputTopic, Produced.with(Serdes.String(), Serdes.Double()));

        try (KafkaStreams kafkaStreams = new KafkaStreams(builder.build(), streamsProps)) {
            final CountDownLatch shutdownLatch = new CountDownLatch(1);

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                kafkaStreams.close(Duration.ofSeconds(2));
                shutdownLatch.countDown();
            }));
            TopicLoader.runProducer();
            try {
                // Finally, start the Kafka Streams application, making sure to let it run for more than 30 seconds:
                kafkaStreams.start();
                shutdownLatch.await();
            } catch (Throwable e) {
                System.exit(1);
            }
        }
        System.exit(0);
    }
}
