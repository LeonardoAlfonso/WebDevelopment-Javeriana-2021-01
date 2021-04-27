package com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class ProductColorDetails {

    private String productColorId;
    private String name;
    private Double quantity;
    private Boolean hasStoke;
    private String rbg;

    public ProductColorDetails(String productColorId, String name, Double quantity, Boolean hasStoke, String rbg) {
        this.productColorId = productColorId;
        this.name = name;
        this.quantity = quantity;
        this.hasStoke = hasStoke;
        this.rbg = rbg;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", productColorId);
            put("name", name);
            put("quantity", quantity);
            put("hasStoke", hasStoke);
            put("rbg", rbg);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductColorDetails that = (ProductColorDetails) o;
        return Objects.equals(productColorId, that.productColorId) && Objects.equals(name, that.name) && Objects.equals(quantity, that.quantity) && Objects.equals(hasStoke, that.hasStoke) && Objects.equals(rbg, that.rbg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productColorId, name, quantity, hasStoke, rbg);
    }

    public String getProductColorId() {
        return this.productColorId;
    }

    public boolean equalsProductColorId(ProductColorDetails productColorDetails) {
        return this.productColorId.equals(productColorDetails.getProductColorId());
    }

    private ProductColorDetails () {}
}
