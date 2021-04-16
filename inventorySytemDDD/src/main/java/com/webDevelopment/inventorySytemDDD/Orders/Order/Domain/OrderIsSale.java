package com.webDevelopment.inventorySytemDDD.Orders.Order.Domain;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.BooleanValueObject;

public class OrderIsSale extends BooleanValueObject {
    public OrderIsSale(Boolean isSale) {
        this.validate(isSale);
        this.value = isSale;
    }

    private OrderIsSale() {}

    private void validate(Boolean value) {

    }
}
