package com.webDevelopment.inventorySytemDDD.Products.Product.Application.Create;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Ports.ProductRepository;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Product;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductDescription;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductId;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductName;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductTotalSales;

public class ProductCreator {

    private ProductRepository repository;

    public ProductCreator(ProductRepository repository) {
        this.repository = repository;
    }

    public void execute(String productId, String productName, String productDescription)
    {
        Product product = Product.create(new ProductId(productId), new ProductName(productName), new ProductDescription(productDescription), new ProductTotalSales(1d));
        repository.save(product);
    }
}
