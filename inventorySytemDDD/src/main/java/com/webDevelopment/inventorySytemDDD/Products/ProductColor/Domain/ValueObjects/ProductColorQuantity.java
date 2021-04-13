package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ValueObjects;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.DoubleValueObject;

public class ProductColorQuantity extends DoubleValueObject {

    private ProductColorQuantity () {
        super();
    }

    public ProductColorQuantity(Double quantity) {
        this.validate(quantity);
        this.value = quantity;
    }

    private void validate(Double quantity) {

    }
}
