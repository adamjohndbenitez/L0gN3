package examples;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

@Service
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(id = "myConsumer", topics = "purchases", autoStartup = "false")
    public void listen(String value,
        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
        @Header(KafkaHeaders.RECEIVED_KEY) String key) {
        logger.info(String.format("Consumed event from topic %s: key = %-10s value = %s", topic, key, value));
    }
//    public void consume(ConsumerRecord<String, String> record) {
//        logger.info(
//            String.format(
//                "Consumed event from topic %s: key = %-10s value = %s",
//                record.topic(),
//                record.key(),
//                record.value()
//            )
//        );
//    }

}
