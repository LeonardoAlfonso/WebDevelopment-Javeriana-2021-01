package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.Exceptions;

public class RBGError extends RuntimeException{
    public RBGError(String message) {
        super(message);
    }
}
