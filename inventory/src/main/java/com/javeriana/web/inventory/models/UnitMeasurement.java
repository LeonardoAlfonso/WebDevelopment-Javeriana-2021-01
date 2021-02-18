package com.javeriana.web.inventory.models;

public class UnitMeasurement {

    private long id;
    private String name;
    private String initial;
    private boolean enabled;

    public UnitMeasurement(long id, String name, String initial, boolean enabled) {
        this.id = id;
        this.name = name;
        this.initial = initial;
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

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
