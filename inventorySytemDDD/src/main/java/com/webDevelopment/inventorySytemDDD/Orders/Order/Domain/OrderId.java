package com.webDevelopment.inventorySytemDDD.Orders.Order.Domain;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.CustomUUID;

public class OrderId extends CustomUUID {
    public OrderId(String value) {
        super(value);
    }

    private OrderId() {
        super("");
    }
}
