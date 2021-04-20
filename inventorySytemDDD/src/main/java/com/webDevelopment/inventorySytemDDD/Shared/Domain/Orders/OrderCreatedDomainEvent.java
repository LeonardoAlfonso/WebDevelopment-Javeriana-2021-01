package com.webDevelopment.inventorySytemDDD.Shared.Domain.Orders;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class OrderCreatedDomainEvent extends DomainEvent {

    private final double quantity;
    private final boolean isSale;

    public OrderCreatedDomainEvent() {
        super(null);
        this.quantity = 0;
        this.isSale = true;
    }

    public OrderCreatedDomainEvent(String aggregateId, double quantity, boolean isSale) {
        super(aggregateId);
        this.quantity = quantity;
        this.isSale = isSale;
    }

    public OrderCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, double quantity, boolean isSale) {
        super(aggregateId, eventId, occurredOn);
        this.quantity = quantity;
        this.isSale = isSale;
    }

    public double getQuantity() {
        return quantity;
    }

    public boolean isSale() {
        return isSale;
    }

    @Override
    public String eventName() {
        return "order.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>() {{
            put("quantity", quantity);
            put("isSale", isSale);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new OrderCreatedDomainEvent(aggregateId,
                eventId,
                occurredOn,
                (double) body.get("quantity"),
                (boolean) body.get("isSale"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderCreatedDomainEvent that = (OrderCreatedDomainEvent) o;
        return Double.compare(that.quantity, quantity) == 0 && isSale == that.isSale;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, isSale);
    }
}
