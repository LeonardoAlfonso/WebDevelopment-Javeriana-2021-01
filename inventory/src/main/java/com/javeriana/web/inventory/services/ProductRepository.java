package com.javeriana.web.inventory.services;

import com.javeriana.web.inventory.models.Product;
import com.javeriana.web.inventory.models.UnitMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findAllByUnitMeasurement(UnitMeasurement unitMeasurement);

    @Query(value = "SELECT p FROM Product p WHERE p.enabled = true")
    public List<Product> findProductsEnabled();
}
