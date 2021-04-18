package com.webDevelopment.inventorySytemDDD.Products.Product.Domain;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.*;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductColorId;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductId;

import java.util.*;

public class Product
{
    private ProductId productId;
    private ProductName productName;
    private ProductDescription productDescription;

    public ProductTotalSales getProductTotalSales() {
        return productTotalSales;
    }

    private ProductTotalSales productTotalSales;
    private Optional<ProductColors> productColors;
    private List<ProductColorId> existingColors;

    public Product(ProductId productId,
                   ProductName productName,
                   ProductDescription productDescription,
                   ProductTotalSales productTotalSales,
                   Optional<ProductColors> productColors,
                   List<ProductColorId> existingColors
    ) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productTotalSales = productTotalSales;
        this.productColors = productColors;
        this.existingColors = existingColors;
    }

    public static Product create(ProductId productId,
                                 ProductName productName,
                                 ProductDescription productDescription,
                                 ProductTotalSales productTotalSales)
    {
        List<ProductColorId> existingColors = new ArrayList<ProductColorId>();
        return new Product(productId, productName, productDescription, productTotalSales, Optional.ofNullable(null),existingColors);
    }

    public void addProductColor(ProductColorId productColorId){
        this.existingColors.add(productColorId);
    }

    public void UpdateSales(ProductTotalSales Sale)
    {
        Double newBalance = this.productTotalSales.value() + Sale.value();
        this.productTotalSales = new ProductTotalSales(newBalance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productDescription, product.productDescription) &&
                Objects.equals(existingColors, product.existingColors);
    }

    public HashMap<String, String> data()
    {
        HashMap<String, String> data = new HashMap<String, String>() {{
            put("id", productId.value());
            put("name", productName.value());
            put("description", productDescription.value());
        }};
        return data;
    }

    private Product(){}
}
