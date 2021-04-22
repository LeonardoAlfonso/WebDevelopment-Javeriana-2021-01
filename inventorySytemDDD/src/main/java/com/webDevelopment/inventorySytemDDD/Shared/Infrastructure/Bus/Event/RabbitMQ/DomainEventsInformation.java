package com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Bus.Event.RabbitMQ;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event.DomainEvent;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Orders.OrderCreatedDomainEvent;

import java.util.HashMap;

public class DomainEventsInformation {

    private final HashMap<String, Class<? extends DomainEvent>> indexedDomainEvents = new HashMap<>();
    private final HashMap<String, String> domainEventSubscribers = new HashMap<>();

    public DomainEventsInformation () {
        indexedDomainEvents.put("order.created", OrderCreatedDomainEvent.class);
        domainEventSubscribers.put("webDevelopment.inventorySystemDDD.Products.ProductColor.update_quantity_on_order_created", "UpdateQuantityOnOrderCreated");
    }

    public Class<? extends DomainEvent> getDomainEvent(String name) {
        return indexedDomainEvents.get(name);
    }

    public boolean validateEventSubscriber(String name) {
        return domainEventSubscribers.containsKey(name);
    }

    public String getEventSubscriber(String name) {
        return domainEventSubscribers.get(name);
    }

}
