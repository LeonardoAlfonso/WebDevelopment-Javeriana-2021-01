package com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.StringValueObject;

public class ProductDetailDescription extends StringValueObject {
    public ProductDetailDescription(String description) {
        this.value = description;
    }
}
