package com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Bus.Event.RabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RabbitMqEventBusConfiguration {

    @Autowired
    private Environment env;

    public RabbitMqEventBusConfiguration(
            Environment env
    ) {
        this.env = env;
    }

    @Bean
    public CachingConnectionFactory connection() {
        CachingConnectionFactory factory = new CachingConnectionFactory();

        factory.setHost(env.getProperty("rabbit.host"));
        factory.setPort(Integer.parseInt(env.getProperty("rabbit.port")));
        factory.setUsername(env.getProperty("rabbit.user"));
        factory.setPassword(env.getProperty("rabbit.password"));
        return factory;
    }

    @Bean
    public Declarables declaration() {
        List<Declarable> declarables = new ArrayList<>();
        TopicExchange domainEventsExchange = new TopicExchange("domain_events", true, false);
        declarables.add(domainEventsExchange);

        Queue queue = QueueBuilder.durable("update_quantity_on_order_created").build();

        Binding fromExchangeSameQueueBinding = BindingBuilder
                .bind(queue)
                .to(domainEventsExchange)
                .with("update_quantity_on_order_created");

        Binding fromExchangeSameQueueEventBinding = BindingBuilder
                .bind(queue)
                .to(domainEventsExchange)
                .with("order.created");

        declarables.add(queue);
        declarables.add(fromExchangeSameQueueBinding);
        declarables.add(fromExchangeSameQueueEventBinding);

        return new Declarables(declarables);
    }
}
