package net.kafka_microservices.orderservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

// @Autowired
@Configuration
public class KafkaTopicConfig {

    // @Autowired
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    // spring beans for kafka topic

    @Bean
    // @Autowired
    public NewTopic topic() {
        return TopicBuilder.name(topicName).build();
        // .partitions(3)

    }

}
