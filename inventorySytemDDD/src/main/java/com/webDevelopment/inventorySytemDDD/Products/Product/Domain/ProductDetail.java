package com.webDevelopment.inventorySytemDDD.Products.Product.Domain;

import java.util.HashMap;
import java.util.Objects;

public class ProductDetail
{
    private String productDetailId;
    private String productDetailDescription;

    public ProductDetail(String productDetailId, String productDetailDescription) {
        this.productDetailId = productDetailId;
        this.productDetailDescription = productDetailDescription;
    }

    public HashMap<String, Object> data()
    {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", productDetailId);
            put("detail", productDetailDescription);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDetail that = (ProductDetail) o;
        return Objects.equals(productDetailId, that.productDetailId) && Objects.equals(productDetailDescription, that.productDetailDescription);
    }

    private ProductDetail() {
    }
}
