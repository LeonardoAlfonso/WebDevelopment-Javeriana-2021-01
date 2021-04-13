package com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Exceptions;

public class ProductNotExist extends RuntimeException {
    public ProductNotExist(String message) {
        super(message);
    }
}
