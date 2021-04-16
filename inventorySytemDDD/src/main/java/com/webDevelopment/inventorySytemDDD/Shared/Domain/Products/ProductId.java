package com.webDevelopment.inventorySytemDDD.Shared.Domain.Products;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.CustomUUID;

public class ProductId extends CustomUUID
{
    private ProductId()
    {
        super("");
    }

    public ProductId(String value) {
        super(value);
    }
}
