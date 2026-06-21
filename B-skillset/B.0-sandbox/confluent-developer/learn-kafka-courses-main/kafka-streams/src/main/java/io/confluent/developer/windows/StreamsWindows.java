package io.confluent.developer.windows;

import io.confluent.developer.StreamsUtils;
import io.confluent.developer.avro.ElectronicOrder;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.TimeWindows;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import static org.apache.kafka.streams.kstream.Suppressed.*;
import static org.apache.kafka.streams.kstream.Suppressed.BufferConfig.*;

public class StreamsWindows {

    public static void main(String[] args) throws IOException {

        final Properties streamsProps = StreamsUtils.loadProperties();
        streamsProps.put(StreamsConfig.APPLICATION_ID_CONFIG, "windowed-streams");

        StreamsBuilder builder = new StreamsBuilder();
        final String inputTopic = streamsProps.getProperty("windowed.input.topic");
        final String outputTopic = streamsProps.getProperty("windowed.output.topic");
        final Map<String, Object> configMap = StreamsUtils.propertiesToMap(streamsProps);

        final SpecificAvroSerde<ElectronicOrder> electronicSerde =
                StreamsUtils.getSpecificAvroSerde(configMap);

        // Use builder.stream to create a KStream named electronicStream, with a peek operator to observe incoming events:
        final KStream<String, ElectronicOrder> electronicStream =
                builder.stream(inputTopic, Consumed.with(Serdes.String(), electronicSerde))
                        .peek((key, value) -> System.out.println("Incoming record - key " + key + " value " + value));

        // Perform a groupByKey, and add a one-hour tumbling window with a grace period of five minutes:
        electronicStream.groupByKey()
                .windowedBy(TimeWindows.of(Duration.ofHours(1)).grace(Duration.ofMinutes(5)))
                // Window the aggregation by the hour and allow for records to be up 5 minutes late
                .aggregate(() -> 0.0,
                        (key, order, total) -> total + order.getPrice(),
                        // Add SerDes for the types in the aggregation, which are used by the state store. Then, add a suppress operator in order to not emit any updates until the window closes:
                        Materialized.with(Serdes.String(), Serdes.Double()))
                // This gives a single result for the windowed aggregation. (The unbounded parameter means that the buffer will continue to consume memory as needed until the window closes.) Suppression is optional, particularly if you want to see any intermediate results.
                .suppress(untilWindowCloses(unbounded()))

                // Don't emit results until the window closes HINT suppression
                .toStream()
                // When windowing Kafka Streams wraps the key in a Windowed class
                // After converting the table to a stream it's a good idea to extract the
                // Underlying key from the Windowed instance HINT: use map
                // Convert the KTable to a KStream, map the windowed key to an underlying record key, add a peek operator to view the underlying result, and add a to operator to write the results to a topic:
                .map((wk, value) -> KeyValue.pair(wk.key(), value))
                .peek((key, value) -> System.out.println("Outgoing record - key " + key + " value " + value))
                .to(outputTopic, Produced.with(Serdes.String(), Serdes.Double()));

        try (KafkaStreams kafkaStreams = new KafkaStreams(builder.build(), streamsProps)) {
            final CountDownLatch shutdownLatch = new CountDownLatch(1);

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                kafkaStreams.close(Duration.ofSeconds(2));
                shutdownLatch.countDown();
            }));
            TopicLoader.runProducer();
            try {
                kafkaStreams.start();
                shutdownLatch.await();
            } catch (Throwable e) {
                System.exit(1);
            }
        }
        System.exit(0);
    }
}
