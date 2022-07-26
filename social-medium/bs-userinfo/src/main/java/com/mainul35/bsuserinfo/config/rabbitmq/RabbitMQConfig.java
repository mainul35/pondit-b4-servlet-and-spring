package com.mainul35.bsuserinfo.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConfig {

    public static final String RMQ_EXCHANGE = "user_create.exchange";
    public static final String RMQ_NAME = "user_create.queue";
    public static final String RMQ_ROUTING_KEY = "user_create.routingKey";

    @Bean
    Queue queue() {
        return new Queue(RMQ_NAME);
    }
}
