package com.webDevelopment.inventorySytemDDD.Orders.Order.Domain;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.IntegerValueObject;
import com.webDevelopment.inventorySytemDDD.Orders.Order.Domain.OrderQuantityNotValid;

public class OrderQuantity extends IntegerValueObject  {
    public OrderQuantity(Integer quantity) {
        this.validate(quantity);
        this.value = quantity;
    }

    private void validate(Integer value) {
        if (value <= 0) {
            throw new OrderQuantityNotValid("The quantity must be greater than 0");
        }
    }
}
