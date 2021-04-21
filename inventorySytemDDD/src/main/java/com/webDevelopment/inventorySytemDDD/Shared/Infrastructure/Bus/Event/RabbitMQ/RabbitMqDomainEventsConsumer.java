package com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Bus.Event.RabbitMQ;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event.DomainEvent;
import com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Bus.Event.RabbitMQ.Serializable.DomainEventJsonDeserializer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Component
public class RabbitMqDomainEventsConsumer {

    private final DomainEventJsonDeserializer deserializer;
    private final DomainEventsInformation information;

    @Autowired
    private final ApplicationContext context;

    public RabbitMqDomainEventsConsumer(DomainEventJsonDeserializer deserializer,
                                        DomainEventsInformation information,
                                        ApplicationContext context) {
        this.deserializer = deserializer;
        this.information = information;
        this.context = context;
    }

    @RabbitListener(queues = "#{'${rabbit.queues}'.split(',')}")
    public void consumer(Message message) throws Exception {
        String serializedMessage = new String(message.getBody());
        DomainEvent domainEvent       = deserializer.deserialize(serializedMessage);
        String queue = message.getMessageProperties().getConsumerQueue();
        Object subscriber = subscriberFor(queue);
        Method subscriberOnMethod = subscriber.getClass().getMethod("on", domainEvent.getClass());
        try {
            subscriberOnMethod.invoke(subscriber, domainEvent);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException error) {
            throw new Exception(String.format(
                    "The subscriber <%s> should implement a method `on` listening the domain event <%s>",
                    queue, domainEvent.eventName()));
        } catch (Exception error) {
            System.err.println("Error " + error.toString());
        }
    }

    private Object subscriberFor(String queue) throws Exception {
        if(!this.information.validateEventSubscriber(queue)) {
            throw new Exception(String.format("There are not registered subscribers for <%s> queue", queue));
        }
        String eventSubscriberName = this.information.getEventSubscriber(queue);
        Object subscriber = context.getBean(eventSubscriberName);
        return subscriber;
    }

}
