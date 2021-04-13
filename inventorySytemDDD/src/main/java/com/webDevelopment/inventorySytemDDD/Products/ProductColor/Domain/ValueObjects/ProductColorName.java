package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ValueObjects;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.StringValueObject;
import com.webDevelopment.inventorySytemDDD.Users.User.Domain.LengthNotValid;

public class ProductColorName extends StringValueObject {

    private ProductColorName() {
    }

    public ProductColorName(String name) {
        this.validate(name);
        this.value = name;
    }

    private void validate(String name) {
        if (name.length() < 3) {
            throw new LengthNotValid("Number of characters invalid");
        }
    }

}
