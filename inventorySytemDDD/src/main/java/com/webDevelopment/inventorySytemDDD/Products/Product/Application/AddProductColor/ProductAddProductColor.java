package com.webDevelopment.inventorySytemDDD.Products.Product.Application.AddProductColor;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Exceptions.ProductNotExist;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Ports.ProductRepository;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Product;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductColorDetails;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductTotalSales;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductColorId;

import java.util.Optional;

public class ProductAddProductColor {

    private ProductRepository repository;

    public ProductAddProductColor(ProductRepository repository) {
        this.repository = repository;
    }

    public void execute(String productId, String productColorId, String name, double quantity, boolean hasStoke, String rgb)
    {
        Optional<Product> product = repository.find(productId);
        if (product.isEmpty())
        {
            throw new ProductNotExist("The product " + productId + " not exists");
        }
        Product finalProduct = product.get();
        finalProduct.addProductColorDetail(new ProductColorDetails(productColorId, name, quantity, hasStoke, rgb));
        repository.update(finalProduct);
    }

}
