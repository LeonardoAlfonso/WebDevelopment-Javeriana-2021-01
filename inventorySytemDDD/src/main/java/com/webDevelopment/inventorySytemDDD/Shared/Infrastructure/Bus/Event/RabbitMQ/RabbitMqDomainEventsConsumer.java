package com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Bus.Event.RabbitMQ;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.stereotype.Service;

import java.util.Set;

public class RabbitMqDomainEventsConsumer {

    private final String CONSUMER_NAME = "domain_events_consumer";
    RabbitListenerEndpointRegistry registry;

    public RabbitMqDomainEventsConsumer(RabbitListenerEndpointRegistry registry) {
        this.registry = registry;
    }

    public void consume() {
        Set<String> ids = registry.getListenerContainerIds();
//        AbstractMessageListenerContainer container = (AbstractMessageListenerContainer) registry.getListenerContainer(null);

//        container.addQueueNames("update_quantity_on_order_created");
//
//        container.start();
    }

    @RabbitListener(id = CONSUMER_NAME, autoStartup = "false")
    public void consumer(Message message) throws Exception {
        String serializedMessage = new String(message.getBody());
    }

}
