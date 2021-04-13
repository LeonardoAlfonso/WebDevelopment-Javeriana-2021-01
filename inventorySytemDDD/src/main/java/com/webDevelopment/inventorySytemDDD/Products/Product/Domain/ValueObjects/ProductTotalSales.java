package com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Exceptions.NegativeBalance;

import java.util.Objects;

public class ProductTotalSales {

    private Double value;

    public ProductTotalSales(Double totalSales) {

        this.validate(totalSales);
        value = totalSales;
    }

    private void validate(Double totalSales) {
        if (totalSales < 0)
        {
            throw new NegativeBalance("The total :" +  totalSales + " could not be negative");
        }
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTotalSales that = (ProductTotalSales) o;
        return Objects.equals(value, that.value);
    }
}
