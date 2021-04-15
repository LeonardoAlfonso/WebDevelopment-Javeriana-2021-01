package com.webDevelopment.inventorySytemDDD.Products.Product.Application.All;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Ports.ProductRepository;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Product;

import java.util.List;
import java.util.Optional;

public class ProductAll {

    private ProductRepository repository;

    public ProductAll(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> execute()
    {
        Optional<List<Product>> products = repository.all();
        if (products.isEmpty())
        {
            //TODO: Exception
        }
        return products.get();
    }
}
