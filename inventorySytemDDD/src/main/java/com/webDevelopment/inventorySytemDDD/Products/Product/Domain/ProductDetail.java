package com.webDevelopment.inventorySytemDDD.Products.Product.Domain;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductDetailDescription;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductDetailId;

import java.util.HashMap;
import java.util.Objects;

public class ProductDetail
{
    private ProductDetailId productDetailId;
    private ProductDetailDescription productDetailDescription;

    public ProductDetail(ProductDetailId productDetailId, ProductDetailDescription productDetailDescription) {
        this.productDetailId = productDetailId;
        this.productDetailDescription = productDetailDescription;
    }

    public HashMap<String, String> data()
    {
        HashMap<String, String> data = new HashMap<String, String>() {{
            put("id", productDetailId.value());
            put("detail", productDetailDescription.value());
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
