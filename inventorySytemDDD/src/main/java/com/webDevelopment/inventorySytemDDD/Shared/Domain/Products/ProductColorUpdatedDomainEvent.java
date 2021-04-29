package com.webDevelopment.inventorySytemDDD.Shared.Domain.Products;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class ProductColorUpdatedDomainEvent extends DomainEvent {

    private final String productColorId;
    private final String name;
    private final double quantity;
    private final boolean hasStock;
    private final String rgb;

    public ProductColorUpdatedDomainEvent() {
        super(null);
        this.productColorId = "";
        this.name = "";
        this.quantity = 0;
        this.hasStock = true;
        this.rgb = "";
    }

    public ProductColorUpdatedDomainEvent(String aggregateId, String productColorId, String name, double quantity, boolean hasStock, String rgb) {
        super(aggregateId);
        this.productColorId = productColorId;
        this.name = name;
        this.quantity = quantity;
        this.hasStock = hasStock;
        this.rgb = rgb;
    }

    public ProductColorUpdatedDomainEvent(String aggregateId, String eventId, String occurredOn, String productColorId, String name, double quantity, boolean hasStock, String rgb) {
        super(aggregateId, eventId, occurredOn);
        this.productColorId = productColorId;
        this.name = name;
        this.quantity = quantity;
        this.hasStock = hasStock;
        this.rgb = rgb;
    }

    @Override
    public String eventName() {
        return "product.color.updated";
    }


    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>() {{
            put("productColorId", productColorId);
            put("name", name);
            put("quantity", quantity);
            put("hasStock", hasStock);
            put("rgb", rgb);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new ProductColorUpdatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("productColorId"),
                (String) body.get("name"),
                (double) body.get("quantity"),
                (boolean) body.get("hasStock"),
                (String) body.get("rgb")
        );
    }

    public String getProductColorId() {
        return productColorId;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public boolean isHasStock() {
        return hasStock;
    }

    public String getRgb() {
        return rgb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductColorUpdatedDomainEvent that = (ProductColorUpdatedDomainEvent) o;
        return Double.compare(that.quantity, quantity) == 0 && hasStock == that.hasStock && productColorId.equals(that.productColorId) && name.equals(that.name) && rgb.equals(that.rgb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productColorId, name, quantity, hasStock, rgb);
    }
}
