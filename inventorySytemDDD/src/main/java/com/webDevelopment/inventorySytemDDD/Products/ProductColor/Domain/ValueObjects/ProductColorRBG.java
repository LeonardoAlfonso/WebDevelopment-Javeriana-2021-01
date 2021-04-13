package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ValueObjects;

import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.Exceptions.RBGError;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.StringValueObject;

import java.util.regex.Pattern;

public class ProductColorRBG extends StringValueObject {

    private ProductColorRBG() {
        super();
    }

    public ProductColorRBG(String rgb) {
        this.validate(rgb);
        this.value = rgb;
    }

    public void validate(String rgb) {
        //TODO: Create Validation
        Pattern pattern = Pattern.compile("(?:#|0x)(?:[a-f0-9]{3}|[a-f0-9]{6})\\b|(?:rgb|hsl)a?\\([^\\)]*\\)");
        boolean match = pattern.matcher(rgb).find();
        if (!match)
        {
            throw new RBGError("The RGB Color is not valid.");
        }
    }

}

