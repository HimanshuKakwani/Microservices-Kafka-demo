package net.kafka_microservices.orderservice.kafka;

// import java.util.logging.Logger;

import org.apache.kafka.clients.admin.NewTopic;
// import org.apache.kafka.common.protocol.Message;
// import org.springframework.messaging.support.*;
import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.kafka.support.KafkaHeaderMapper;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

// import net.kafka_microservices.dto.Order;
import net.kafka_microservices.dto.OrderEvent;

@Service
public class OrderProducer {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

    // @Autowired
    private NewTopic topic;

    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public OrderProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(OrderEvent event) {

        LOGGER.info(String.format("Order Event = %s", event.toString()));

        // create message
        org.springframework.messaging.Message<OrderEvent> message = MessageBuilder.withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        kafkaTemplate.send(message);
    }

}
