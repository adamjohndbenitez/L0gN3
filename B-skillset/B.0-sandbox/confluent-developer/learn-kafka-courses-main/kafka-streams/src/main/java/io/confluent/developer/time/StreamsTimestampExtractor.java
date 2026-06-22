package io.confluent.developer.time;

import io.confluent.developer.StreamsUtils;
import io.confluent.developer.avro.ElectronicOrder;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.clients.consumer.ConsumerRecord;
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
import org.apache.kafka.streams.processor.TimestampExtractor;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class StreamsTimestampExtractor {

    // create an instance of a TimestampExtractor, implementing the extract method and retrieving the ElectronicOrder object from the ConsumerRecord value field; then extract and return the timestamp embedded in the `ElectronicOrder':
    static class OrderTimestampExtractor implements TimestampExtractor {
        @Override
        public long extract(ConsumerRecord<Object, Object> record, long partitionTime) {
            // Extract the timestamp from the value in the record
            // and return that instead
            ElectronicOrder order = (ElectronicOrder)record.value();
            System.out.println("Extracting time of " + order.getTime() + " from " + order);
            return order.getTime();
        }
    }

    public static void main(String[] args) throws IOException {

        final Properties streamsProps = StreamsUtils.loadProperties();
        streamsProps.put(StreamsConfig.APPLICATION_ID_CONFIG, "extractor-windowed-streams");

        StreamsBuilder builder = new StreamsBuilder();
        final String inputTopic = streamsProps.getProperty("extractor.input.topic");
        final String outputTopic = streamsProps.getProperty("extractor.output.topic");
        final Map<String, Object> configMap = StreamsUtils.propertiesToMap(streamsProps);

        final SpecificAvroSerde<ElectronicOrder> electronicSerde =
                StreamsUtils.getSpecificAvroSerde(configMap);

        // create a KStream, and make the familiar builder.stream call:
        final KStream<String, ElectronicOrder> electronicStream =
                builder.stream(inputTopic,
                                // Add the Consumed configuration object with SerDes for deserialization,
                                Consumed.with(Serdes.String(), electronicSerde)
                                        // but with a twist: You're also providing a TimestampExtractor. (You could also specify the TimestampExtractor by configurations, but then it would be global for all streams in the application.)
                                        .withTimestampExtractor(new OrderTimestampExtractor())
                        )
                        //Wire up the timestamp extractor HINT do it on the Consumed object vs configs
                        .peek((key, value) -> System.out.println("Incoming record - key " + key + " value " + value));

        // Create a tumbling window aggregation. Keep in mind that the timestamps from ElectronicOrder are what drive the window opening and closing.
        electronicStream.groupByKey().windowedBy(TimeWindows.of(Duration.ofHours(1)))
                // Call the aggregate method, initializing the aggregate to "0.0" and adding the aggregator instance that sums all prices for the total spent over one hour, based on the timestamp of the record itself. Add SerDes for the state store via a Materialized, and convert the KTable from the aggregation into a KStream.
                .aggregate(() -> 0.0,
                        (key, order, total) -> total + order.getPrice(),
                        Materialized.with(Serdes.String(), Serdes.Double()))
                .toStream()
                // Use a map processor to unwrap the windowed key and return the underlying key of the aggregation, and use a peek processor to print the aggregation results to the console. Finally, write the results out to a topic.
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
