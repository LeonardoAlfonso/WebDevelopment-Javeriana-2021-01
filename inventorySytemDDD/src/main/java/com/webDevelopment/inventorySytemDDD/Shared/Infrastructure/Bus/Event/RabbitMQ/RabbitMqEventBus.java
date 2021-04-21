package com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Bus.Event.RabbitMQ;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event.DomainEvent;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event.EventBus;
import org.springframework.amqp.AmqpException;

import java.util.List;

public class RabbitMqEventBus implements EventBus {
    private final RabbitMqPublisher publisher;
    private final String            exchangeName;

    public RabbitMqEventBus(RabbitMqPublisher publisher) {
        this.publisher         = publisher;
        this.exchangeName      = "domain_events";
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        try {
            this.publisher.publish(domainEvent, exchangeName);
        } catch (AmqpException error) {
            System.err.println("Error Publicando: " + error.toString());
            //TODO:: Implementar un Failover de Rabbit
        }
    }
}
