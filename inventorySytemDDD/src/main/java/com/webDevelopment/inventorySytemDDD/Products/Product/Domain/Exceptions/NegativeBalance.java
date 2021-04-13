package com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Exceptions;

public class NegativeBalance extends RuntimeException {
    public NegativeBalance(String message) {
        super(message);
    }
}
