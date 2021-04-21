package com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Bus.Event.RabbitMQ;

import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Application.UpdateQuantity.UpdateQuantityOnOrderCreated;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event.DomainEvent;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Orders.OrderCreatedDomainEvent;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DomainEventsInformation {
    private final HashMap<String, Class<? extends DomainEvent>>     indexedDomainEvents = new HashMap<>();
    private final HashMap<String, Class<?>> domainEventSubscribers = new HashMap<>();

    public DomainEventsInformation() {
        indexedDomainEvents.put("order.created", OrderCreatedDomainEvent.class);
        domainEventSubscribers.put("webDevelopment.inventorySystemDDD.Products.ProductColor.update_quantity_on_order_created", UpdateQuantityOnOrderCreated.class);
    }

    public Class<? extends DomainEvent> getDomainEvent(String name) {
        return indexedDomainEvents.get(name);
    }

    public boolean validateEventSubscriber(String name) {
        return domainEventSubscribers.containsKey(name);
    }

    public Class<?> getEventSubscriber(String name) {
        return domainEventSubscribers.get(name);
    }
}
