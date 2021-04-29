package com.webDevelopment.inventorySytemDDD.Shared.Infrastructure.Bus.Event.RabbitMQ;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event.DomainEvent;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Orders.OrderCreatedDomainEvent;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductColorCreatedDomainEvent;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductColorUpdatedDomainEvent;

import java.util.HashMap;

public class DomainEventsInformation {

    private final HashMap<String, Class<? extends DomainEvent>> indexedDomainEvents = new HashMap<>();
    private final HashMap<String, String> domainEventSubscribers = new HashMap<>();

    public DomainEventsInformation () {
        indexedDomainEvents.put("order.created", OrderCreatedDomainEvent.class);
        indexedDomainEvents.put("product.color.created", ProductColorCreatedDomainEvent.class);
        indexedDomainEvents.put("product.color.updated", ProductColorUpdatedDomainEvent.class);
        domainEventSubscribers.put("webDevelopment.inventorySystemDDD.Products.ProductColor.update_quantity_on_order_created", "UpdateQuantityOnOrderCreated");
        domainEventSubscribers.put("webDevelopment.inventorySystemDDD.Products.ProductColor.create_product_color", "AddProductColorOnProductColorCreated");
        domainEventSubscribers.put("webDevelopment.inventorySystemDDD.Products.ProductColor.update_product_color", "UpdateProductColorOnProductColorUpdated");
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
