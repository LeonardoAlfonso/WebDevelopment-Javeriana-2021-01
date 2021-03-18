package com.javeriana.web.inventory.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "category", length = 200, nullable = false)
    private String category;

    @ManyToOne
    @JoinColumn(name = "idUnit")
    @JsonIgnoreProperties("products")
    private UnitMeasurement unitMeasurement;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    public Product() {}

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
