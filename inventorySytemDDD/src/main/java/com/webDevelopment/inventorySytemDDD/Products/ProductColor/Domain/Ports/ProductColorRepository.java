package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.Ports;

import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ProductColor;

import java.util.Optional;

public interface ProductColorRepository {
    void update(ProductColor productColor);
    Optional<ProductColor> find (String productColorId);
    void save(ProductColor productColor);
}
