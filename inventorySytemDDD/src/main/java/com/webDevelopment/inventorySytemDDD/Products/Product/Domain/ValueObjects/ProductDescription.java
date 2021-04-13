package com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.StringValueObject;

public class ProductDescription extends StringValueObject {

    private ProductDescription() {}

    public ProductDescription(String description) {
        this.validate(description);
        this.value = description;
    }

    private void validate(String description) {
    }
}
