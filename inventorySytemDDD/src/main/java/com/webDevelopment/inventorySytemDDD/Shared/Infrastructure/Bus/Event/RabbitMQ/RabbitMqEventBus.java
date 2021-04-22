package com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Bus.Event.RabbitMQ;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event.DomainEvent;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event.EventBus;
import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.List;

public class RabbitMqEventBus implements EventBus {

    private final RabbitMqPublisher publisher;
    private final String exchangeName;
    @Autowired
    private Environment env;

    public RabbitMqEventBus(RabbitMqPublisher publisher, Environment env) {
        this.publisher = publisher;
        this.env = env;
        this.exchangeName = env.getProperty("rabbit.exchange");
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        try {
            this.publisher.publish(domainEvent, this.exchangeName);
        }
        catch (AmqpException error) {
            System.err.println("Error Publicando: " + error.toString());
            //TODO: Implementar un Failover de Rabbit
        }
    }
}
