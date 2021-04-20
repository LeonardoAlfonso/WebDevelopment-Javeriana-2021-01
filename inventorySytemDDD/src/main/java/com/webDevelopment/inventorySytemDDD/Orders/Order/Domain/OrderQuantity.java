package com.webDevelopment.inventorySytemDDD.Orders.Order.Domain;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.DoubleValueObject;
import com.webDevelopment.inventorySytemDDD.Orders.Order.Domain.OrderQuantityNotValid;

public class OrderQuantity extends DoubleValueObject {

    private OrderQuantity() {}

    public OrderQuantity(Double quantity) {
        this.validate(quantity);
        this.value = quantity;
    }

    private void validate(Double value) {
        int result = value.compareTo(0d);
        if (result <= 0) {
            throw new OrderQuantityNotValid("The quantity must be greater than 0");
        }
    }
}
