package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Application.Find;

import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.Ports.ProductColorRepository;
import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ProductColor;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductColorId;

import java.util.Optional;

public class ProductColorFinder {

    private ProductColorRepository repository;

    public ProductColorFinder(ProductColorRepository repository) {
        this.repository = repository;
    }

    public ProductColor execute(String id)
    {
        Optional<ProductColor> result = repository.find(new ProductColorId(id).value());
        if (result.isEmpty())
        {
            throw new RuntimeException("Error");
        }
        ProductColor productColor = result.get();
        return productColor;
    }

}
