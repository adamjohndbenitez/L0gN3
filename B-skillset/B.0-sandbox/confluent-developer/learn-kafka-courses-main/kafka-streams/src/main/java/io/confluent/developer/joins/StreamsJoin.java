package io.confluent.developer.joins;

import io.confluent.developer.StreamsUtils;
import io.confluent.developer.avro.ApplianceOrder;
import io.confluent.developer.avro.CombinedOrder;
import io.confluent.developer.avro.ElectronicOrder;
import io.confluent.developer.avro.User;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.JoinWindows;
import org.apache.kafka.streams.kstream.Joined;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.StreamJoined;
import org.apache.kafka.streams.kstream.ValueJoiner;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class StreamsJoin {

    // Use a static helper method to get SerDes for your Avro records (in subsequent exercises, you'll abstract this into a static utility method, in the StreamsUtils class of the course repo):
    static <T extends SpecificRecord> SpecificAvroSerde<T> getSpecificAvroSerde(final Map<String, Object> serdeConfig) {
        final SpecificAvroSerde<T> specificAvroSerde = new SpecificAvroSerde<>();
        specificAvroSerde.configure(serdeConfig, false);
        return specificAvroSerde;
    }

    public static void main(String[] args) throws IOException {

        // Use a utility method to load the properties (you can refer to the StreamsUtils class
        Properties streamsProps = StreamsUtils.loadProperties();
        streamsProps.put(StreamsConfig.APPLICATION_ID_CONFIG, "joining-streams");

        StreamsBuilder builder = new StreamsBuilder();

        // Get the input topic names and the output topic name from the properties (look at streams.properties (gitignored)):
        String streamOneInput = streamsProps.getProperty("stream_one.input.topic");
        String streamTwoInput = streamsProps.getProperty("stream_two.input.topic");
        String tableInput = streamsProps.getProperty("table.input.topic");
        String outputTopic = streamsProps.getProperty("joins.output.topic");

        // Create a HashMap of the configurations:
        Map<String, Object> configMap = StreamsUtils.propertiesToMap(streamsProps);

        // Then create the required SerDes for all streams and for the table:
        SpecificAvroSerde<ApplianceOrder> applianceSerde = getSpecificAvroSerde(configMap);
        SpecificAvroSerde<ElectronicOrder> electronicSerde = getSpecificAvroSerde(configMap);
        SpecificAvroSerde<CombinedOrder> combinedSerde = getSpecificAvroSerde(configMap);
        SpecificAvroSerde<User> userSerde = getSpecificAvroSerde(configMap);

        // Create the ValueJoiner for the stream-table join:
        ValueJoiner<ApplianceOrder, ElectronicOrder, CombinedOrder> orderJoiner =
                (applianceOrder, electronicOrder) -> CombinedOrder.newBuilder()
                        .setApplianceOrderId(applianceOrder.getOrderId())
                        .setApplianceId(applianceOrder.getApplianceId())
                        .setElectronicOrderId(electronicOrder.getOrderId())
                        .setTime(Instant.now().toEpochMilli())
                        .build();
        // The stream is a result of the preceding stream-stream join, but it's a left outer join, because the right-side record might not exist.

        ValueJoiner<CombinedOrder, User, CombinedOrder> enrichmentJoiner = (combined, user) -> {
            if (user != null) {
                combined.setUserName(user.getName());
            }
            return combined;
        };

        // Create the ApplianceOrder stream as well as the ElectronicOrder stream:
        KStream<String, ApplianceOrder> applianceStream =
                builder.stream(streamOneInput, Consumed.with(Serdes.String(), applianceSerde))
                        .peek((key, value) -> System.out.println("Appliance stream incoming record key " + key + " value " + value));

        KStream<String, ElectronicOrder> electronicStream =
                builder.stream(streamTwoInput, Consumed.with(Serdes.String(), electronicSerde))
                        .peek((key, value) -> System.out.println("Electronic stream incoming record " + key + " value " + value));

        // From here, create the User table:
        KTable<String, User> userTable =
                builder.table(tableInput, Materialized.with(Serdes.String(), userSerde));

        KStream<String, CombinedOrder> combinedStream = applianceStream.join(
        // create a Join between the applianceStream and the electronicStream
        // using the ValueJoiner created above, orderJoiner gets you the correct value type of CombinedOrder
        // You want to join records within 30 minutes of each other HINT: JoinWindows and Duration.ofMinutes
        // Add the correct Serdes for the join state stores remember both sides have same key type
        // HINT: StreamJoined and Serdes.String  and Serdes for the applianceStream and electronicStream created above
                electronicStream,
                orderJoiner,
                JoinWindows.of(Duration.ofMinutes(30)),
                StreamJoined.with(Serdes.String(), applianceSerde, electronicSerde)
        )

        // Optionally add this statement after the join to see the results on the console
        // Add a peek operator to view the results of the join:
         .peek((key, value) -> System.out.println("Stream-Stream Join record key " + key + " value " + value));

        // Now join the combinedStream with the userTable,
        // but you'll always want a result even if no corresponding entry is found in the table
        // Using the ValueJoiner created above, enrichmentJoiner, return a CombinedOrder instance enriched with user information
        // You'll need to add a Joined instance with the correct Serdes for the join state store
        // Call the join method on the KStream that results from the join in previous steps, adding the userTable as the right side in the stream-table join. Then add enrichmentJoiner to add user information, if available. Add the Joined object with SerDes for the values of both sides of the join, add the peek operator to view the stream-table join results, and write the final join results to a topic:
        combinedStream.leftJoin(
                        userTable,
                        enrichmentJoiner,
                        Joined.with(Serdes.String(), combinedSerde, userSerde))

        // Add these two statements after the join call to print results to the console and write results out
        // to a topic
         .peek((key, value) -> System.out.println("Stream-Table Join record key " + key + " value " + value))
         .to(outputTopic, Produced.with(Serdes.String(), combinedSerde));

        // Create the KafkaStreams object, and again use the TopicLoader helper class to create topics and produce exercise data:
        try (KafkaStreams kafkaStreams = new KafkaStreams(builder.build(), streamsProps)) {
            final CountDownLatch shutdownLatch = new CountDownLatch(1);

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                kafkaStreams.close(Duration.ofSeconds(2));
                shutdownLatch.countDown();
            }));
            TopicLoader.runProducer();
            try {
                // Finally, start the Kafka Streams application:
                kafkaStreams.start();
                shutdownLatch.await();
            } catch (Throwable e) {
                System.exit(1);
            }
        }
        System.exit(0);
    }
}
