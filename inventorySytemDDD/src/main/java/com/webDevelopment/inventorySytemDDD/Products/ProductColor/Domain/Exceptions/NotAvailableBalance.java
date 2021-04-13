package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.Exceptions;

public class NotAvailableBalance extends RuntimeException {
    public NotAvailableBalance(String message) {
        super(message);
    }
}
