package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ValueObjects;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.CustomUUID;

public class ProductColorId extends CustomUUID  {

    private ProductColorId() {
        super("");
    }

    public ProductColorId(String value) {
        super(value);
    }
}
