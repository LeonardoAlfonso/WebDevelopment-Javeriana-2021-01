package com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Exceptions;

public class ProductColorNotExist extends RuntimeException{
    public ProductColorNotExist(String message) {
        super(message);
    }
}
