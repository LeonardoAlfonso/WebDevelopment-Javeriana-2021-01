package com.webDevelopment.inventorySytemDDD.Orders.Order.Domain;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.DoubleValueObject;

public class OrderTotal extends DoubleValueObject {
    public OrderTotal(Double total) {
        this.validate(total);
        this.value = total;
    }

    private void validate(Double value) {
        if (value <= 0) {
            throw new OrderTotalNotValid("The Order must be greater than 0");
        }
    }
}
