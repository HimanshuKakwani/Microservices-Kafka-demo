package net.kafka_microservices.emailservice.kafka;


import net.kafka_microservices.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service to  ake class a spring bean
@Service
public class OrderConsumer {

    private final static Logger logger = LoggerFactory. getLogger(OrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event){

        logger.info(String.format("Order info recieved in email service == %s", event.toString()));

        //how to send email to consumer
    }
}
