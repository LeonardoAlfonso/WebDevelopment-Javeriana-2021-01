package com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Bus.Event.RabbitMQ;

import com.google.common.base.CaseFormat;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event.DomainEvent;
import com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Bus.Event.RabbitMQ.Serializable.DomainEventJsonDeserializer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

@Component
public class RabbitMqDomainEventsConsumer {

    private final DomainEventJsonDeserializer deserializer;
    private final DomainEventsInformation information;

    public RabbitMqDomainEventsConsumer(DomainEventJsonDeserializer deserializer,
                                        DomainEventsInformation information) {
        this.deserializer = deserializer;
        this.information = information;
    }

    @RabbitListener(queues = "#{'${rabbitmq.queue.names}'.split(',')}")
    public void consumer(Message message) throws Exception {
        String serializedMessage = new String(message.getBody());
        System.out.println(serializedMessage);
        DomainEvent domainEvent       = deserializer.deserialize(serializedMessage);
        String queue = message.getMessageProperties().getConsumerQueue();
        Class<?> subscriberclass = subscriberFor(queue);
        Method subscriberOnMethod = subscriberclass.getMethod("on", domainEvent.getClass());
        try {
            subscriberOnMethod.invoke(subscriberclass, domainEvent);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException error) {
            throw new Exception(String.format(
                    "The subscriber <%s> should implement a method `on` listening the domain event <%s>",
                    queue, domainEvent.eventName()));
        } catch (Exception error) {
            System.err.println("Error " + error.toString());
        }
    }

    private Class<?> subscriberFor(String queue) throws Exception {
        if(!this.information.validateEventSubscriber(queue)) {
            throw new Exception(String.format("There are not registered subscribers for <%s> queue", queue));
        }
        return this.information.getEventSubscriber(queue);
    }

}
