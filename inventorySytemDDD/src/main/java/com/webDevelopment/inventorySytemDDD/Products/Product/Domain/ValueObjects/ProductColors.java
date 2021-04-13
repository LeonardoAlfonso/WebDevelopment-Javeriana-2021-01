package com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.StringValueObject;

public class ProductColors extends StringValueObject {
    public ProductColors(String jsonProducts) {
        this.validate(jsonProducts);
        this.value = jsonProducts;
    }

    private void validate(String jsonProducts) {
    }
}
