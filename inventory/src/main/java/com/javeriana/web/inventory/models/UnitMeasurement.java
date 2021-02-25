package com.javeriana.web.inventory.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MeasurementUnits")
public class UnitMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUnit")
    private long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "initial", length = 20, nullable = false)
    private String initial;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @OneToMany(mappedBy = "unitMeasurement")
    @JsonIgnoreProperties("unitMeasurement")
    private List<Product> products;

    public UnitMeasurement(){
    }

    public UnitMeasurement(String name, String initial, boolean enabled) {
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
