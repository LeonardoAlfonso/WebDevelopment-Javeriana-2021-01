package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ValueObjects;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.BooleanValueObject;

public class ProductColorIsStock extends BooleanValueObject {

    private ProductColorIsStock() {
    }

    public ProductColorIsStock(Boolean isStock) {
        this.validate(isStock);
        this.value = isStock;
    }

    private void validate(Boolean isStock) {

    }
}
