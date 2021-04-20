package com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.CustomUUID;


public class ProductDetailId extends CustomUUID {

    public ProductDetailId(String value) {
        super(value);
    }
}
