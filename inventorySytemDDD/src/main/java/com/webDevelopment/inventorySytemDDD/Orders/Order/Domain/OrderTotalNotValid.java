package com.webDevelopment.inventorySytemDDD.Orders.Order.Domain;

public class OrderTotalNotValid extends RuntimeException {
    public OrderTotalNotValid(String message) {
        super(message);
    }
}
