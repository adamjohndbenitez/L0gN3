package io.confluent.developer.processor;

import io.confluent.developer.avro.ElectronicOrder;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.processor.api.Processor;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.processor.api.ProcessorSupplier;
import org.apache.kafka.streams.processor.api.Record;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import static io.confluent.developer.StreamsUtils.*;

public class ProcessorApi {

    // Create the ProcessorSupplier implementation:
    static class TotalPriceOrderProcessorSupplier implements ProcessorSupplier<String, ElectronicOrder, String, Double> {
        final String storeName;

        public TotalPriceOrderProcessorSupplier(String storeName) {
            this.storeName = storeName;
        }

        // Add a constructor. The get() method implementation is important, since it returns a new processor instance each time it's called. You'll also declare a variable for ProcessorContext and KeyValueStore, and implement the init method, which is called by Kafka Streams when the application is starting up. In the init method, store a reference to the Processor context, get a reference to the state store by name, and store it in the storeName variable declared above. Then use the processor context to schedule a punctuation that fires every 30 seconds, based on stream time.
        @Override
        public Processor<String, ElectronicOrder, String, Double> get() {
            return new Processor<>() {
                private ProcessorContext<String, Double> context;
                private KeyValueStore<String, Double> store;

                @Override
                public void init(ProcessorContext<String, Double> context) {
                    // Save reference of the context
                    // Retrieve the store and save a reference
                    // Schedule a punctuation  HINT: use context.schedule and the method you want to call is forwardAll
                    this.context = context;
                    store = context.getStateStore(storeName);
                    this.context.schedule(Duration.ofSeconds(30), PunctuationType.STREAM_TIME, this::forwardAll);
                }

                // Implement the forwardAll method, beginning by opening an iterator for all records in the store. (It’s important to close iterators when you're done with them; it's best to use them within a try-with-resources block, so that closing is automatic.)
                private void forwardAll(final long timestamp) {
                    // Get a KeyValueIterator HINT there's a method on the KeyValueStore
                    // Don't forget to close the iterator! HINT use try-with resources
                    // Iterate over the records and create a Record instance and forward downstream HINT use a method on the ProcessorContext to forward
                    try (KeyValueIterator<String, Double> iterator = store.all()) {
                        // Iterate over all of the records, and get a KeyValue from the iterator inside your loop. In addition, create a new Record instance. Then forward the Record to any child nodes.
                        while (iterator.hasNext()) {
                            final KeyValue<String, Double> nextKV = iterator.next();
                            final Record<String, Double> totalPriceRecord = new Record<>(nextKV.key, nextKV.value, timestamp);
                            context.forward(totalPriceRecord);
                            System.out.println("Punctuation forwarded record - key " + totalPriceRecord.key() + " value " + totalPriceRecord.value());
                        }
                    }
                }

                // Implement the Process method on the Processor interface by first getting the key from the Record, then using the key to see if there is a value in the state store. If it's null, initialize it to "0.0". Add the current price from the record to the total, and place the new value in the store with the given key.
                @Override
                public void process(Record<String, ElectronicOrder> record) {
                    // Get the current total from the store HINT: use the key on the record
                    // Don't forget to check for null
                    // Add the price from the value to the current total from store and put it in the store
                    // HINT state stores are key-value stores
                    final String key = record.key();
                    Double currentTotal = store.get(key);
                    if (currentTotal == null) {
                        currentTotal = 0.0;
                    }
                    Double newTotal = record.value().getPrice() + currentTotal;
                    store.put(key, newTotal);
                    System.out.println("Processed incoming record - key " + key + " value " + record.value());
                }
            };
        }

        // With StoreBuilder complete, now override the Stores method on the Processor interface, which gives the Processor access to the store:
        @Override
        public Set<StoreBuilder<?>> stores() {
            return Collections.singleton(totalPriceStoreBuilder);
        }
    }

    // We're not quite done with the ProcessorSupplier implementation, but we have some details to attend to first. Define the storeName variable and create a StoreBuilder, which you'll need for creating the state store. In the StoreBuilder, set the store type to persistent and use the storeName variable for the name of the store. Add SerDes for the key/value types in the store (Kafka Streams stores everything as byte arrays in state stores).
    final static String storeName = "total-price-store";
    static StoreBuilder<KeyValueStore<String, Double>> totalPriceStoreBuilder = Stores.keyValueStoreBuilder(
            Stores.persistentKeyValueStore(storeName),
            Serdes.String(),
            Serdes.Double());

    public static void main(String[] args) throws IOException {
        final Properties streamsProps = loadProperties();
        streamsProps.put(StreamsConfig.APPLICATION_ID_CONFIG, "processor-api-application");

        final String inputTopic = streamsProps.getProperty("processor.input.topic");
        final String outputTopic = streamsProps.getProperty("processor.output.topic");
        final Map<String, Object> configMap = propertiesToMap(streamsProps);

        final SpecificAvroSerde<ElectronicOrder> electronicSerde = getSpecificAvroSerde(configMap);
        final Serde<String> stringSerde = Serdes.String();
        final Serde<Double> doubleSerde = Serdes.Double();

        // Now build a topology for the streaming application. This will take a few more steps since we’re using the Processor API and not the Kafka Streams DSL.
        final Topology topology = new Topology();

        // Add a source node to the topology  HINT: topology.addSource
        // Give it a name, add deserializers for the key and the value and provide the input topic name
        // Begin by creating an instance and adding a source node (you need to provide the names for the source node, SerDes, and input topic):
        topology.addSource(
                "source-node",
                stringSerde.deserializer(),
                electronicSerde.deserializer(),
                inputTopic);

        // Now add a processor to the topology HINT topology.addProcessor
        // You'll give it a name, add a processor supplier HINT: a new instance and provide the store name
        // You'll also provide a parent name HINT: it's the name you used for the source node
        // Next, add a processor to the topology. Provide a name for the Processor, add the ProcessorSupplier instance you created before, and set the parent name(s) for the Processor (you can specify multiple names).
        topology.addProcessor(
                "aggregate-price",
                new TotalPriceOrderProcessorSupplier(storeName),
                "source-node");

        // Finally, add a sink node HINT topology.addSink
        // As before give it a name, the output topic name, serializers for the key and value HINT: string and double
        // and the name of the parent node HINT it's the name you gave the processor
        // Complete the topology by adding a sink node, specifying its name and then adding an output topic, SerDes, and parent name(s):
        topology.addSink(
                "sink-node",
                outputTopic,
                stringSerde.serializer(),
                doubleSerde.serializer(),
                "aggregate-price");

        // Finally, instantiate the kafkaStreams object, add the utility method for creating topics and providing sample data, and start the application.
        try (KafkaStreams kafkaStreams = new KafkaStreams(topology, streamsProps)) {
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
