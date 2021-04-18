package com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Ports;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void update(Product product);
    Optional<Product> find (String ProductId);
    void save(Product product);
    Optional<List<Product>> all();
}
