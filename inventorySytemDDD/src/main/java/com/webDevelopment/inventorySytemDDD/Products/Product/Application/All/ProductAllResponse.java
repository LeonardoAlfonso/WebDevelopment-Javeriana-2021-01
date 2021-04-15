package com.webDevelopment.inventorySytemDDD.Products.Product.Application.All;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Product;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ProductAllResponse {

    private List<Product> products;

    public ProductAllResponse(List<Product> products) {
        this.products = products;
    }

    public List<HashMap> response()
    {
        List<HashMap> response = products.stream().map(p -> p.data()).collect(Collectors.toList());
        products.stream().filter(p -> p.getProductTotalSales().value() > 2000d).collect(Collectors.toList());
        return response;
    }
}
