package com.webDevelopment.inventorySytemDDD.Orders.Order.Domain;

public class OrderQuantityNotValid extends RuntimeException {
    public OrderQuantityNotValid(String message) {
        super(message);
    }
}
