package com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Bus.Event.RabbitMQ;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqDomainEventsConsumer {

    @RabbitListener(queues = {"update_quantity_on_order_created","ssss"})
    public void consumer(Message message) throws Exception {
        String serializedMessage = new String(message.getBody());
    }
}
