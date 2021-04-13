package com.webDevelopment.inventorySytemDDD.Products.Product.Application.AddBalance;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Exceptions.ProductNotExist;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Ports.ProductRepository;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Product;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductTotalSales;

import java.util.Optional;

public class ProductBalanceAdder
{
    private ProductRepository repository;

    public ProductBalanceAdder(ProductRepository repository) {
        this.repository = repository;
    }

    public void execute(String productId, Double balance)
    {
        Optional<Product> product = repository.find(productId);
        if (product.isEmpty())
        {
            throw new ProductNotExist("The product " + productId + " not exists");
        }
        Product finalProduct = product.get();
        finalProduct.UpdateSales(new ProductTotalSales(balance));
        repository.update(productId, finalProduct);
    }
}
