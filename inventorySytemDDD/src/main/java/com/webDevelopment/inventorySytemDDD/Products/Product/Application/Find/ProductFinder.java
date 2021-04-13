package com.webDevelopment.inventorySytemDDD.Products.Product.Application.Find;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Ports.ProductRepository;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Product;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductId;

import java.util.Optional;

public class ProductFinder {

    private ProductRepository repository;

    public ProductFinder(ProductRepository repository) {
        this.repository = repository;
    }

    public Product execute(String id)
    {
        Optional<Product> result = repository.find(new ProductId(id).value());
        if (result.isEmpty())
        {
            throw new RuntimeException("Error");
        }
        Product product = result.get();
        return product;
    }
}
