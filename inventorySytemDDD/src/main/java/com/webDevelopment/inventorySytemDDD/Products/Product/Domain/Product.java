package com.webDevelopment.inventorySytemDDD.Products.Product.Domain;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.*;

import java.util.Objects;
import java.util.Optional;

public class Product
{
    private ProductId productId;
    private ProductName productName;
    private ProductDescription productDescription;
    private ProductTotalSales productTotalSales;
    private Optional<ProductColors> productColors;

    public Product(ProductId productId,
                   ProductName productName,
                   ProductDescription productDescription,
                   ProductTotalSales productTotalSales,
                   Optional<ProductColors> productColors
    ) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productTotalSales = productTotalSales;
        this.productColors = productColors;
    }

    public static Product create(ProductId productId,
                                 ProductName productName,
                                 ProductDescription productDescription,
                                 ProductTotalSales productTotalSales)
    {
        return new Product(productId, productName, productDescription, productTotalSales, Optional.ofNullable(null));
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
                Objects.equals(productDescription, product.productDescription);
    }

    private Product(){}
}
