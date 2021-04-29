package com.webDevelopment.inventorySytemDDD.Products.Product.Application.UpdateProductColor;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Exceptions.ProductNotExist;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Ports.ProductRepository;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Product;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductColorDetails;

import java.util.Optional;

public class ProductUpdateProductColor {

    private ProductRepository repository;

    public ProductUpdateProductColor(ProductRepository repository) {
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
        finalProduct.updateProductColorDetail(new ProductColorDetails(productColorId, name, quantity, hasStoke, rgb));
        repository.update(finalProduct);
    }
}
