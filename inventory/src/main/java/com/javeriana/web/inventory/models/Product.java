package com.javeriana.web.inventory.models;

public class Product {

    private long id;
    private String name;
    private String category;
    private UnitMeasurement unitMeasurement;
    private boolean enabled;

    public Product(long id, String name, String category, UnitMeasurement unitMeasurement, boolean enabled) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.unitMeasurement = unitMeasurement;
        this.enabled = enabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public UnitMeasurement getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(UnitMeasurement unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
