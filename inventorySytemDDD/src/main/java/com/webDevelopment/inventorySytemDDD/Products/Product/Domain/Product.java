package com.webDevelopment.inventorySytemDDD.Products.Product.Domain;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.*;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductId;

import java.util.*;
import java.util.stream.Collectors;

public class Product
{
    private ProductId productId;
    private ProductName productName;
    private ProductDescription productDescription;
    private ProductTotalSales productTotalSales;
    private Optional<ProductDetail> productDetail;
    private Optional<List<ProductColorDetails>> productColors;

    public Product(ProductId productId,
                   ProductName productName,
                   ProductDescription productDescription,
                   ProductTotalSales productTotalSales,
                   ProductDetail productDetail,
                   List<ProductColorDetails> productColors
    ) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productTotalSales = productTotalSales;
        this.productDetail = Optional.ofNullable(productDetail);
        this.productColors = Optional.ofNullable(productColors);
    }

    public static Product create(ProductId productId,
                                 ProductName productName,
                                 ProductDescription productDescription,
                                 ProductTotalSales productTotalSales)
    {
        return new Product(productId, productName, productDescription, productTotalSales, null, null);
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

    public HashMap<String, String> data()
    {
        HashMap<String, String> data = new HashMap<String, String>() {{
            put("id", productId.value());
            put("name", productName.value());
            put("description", productDescription.value());
        }};
        return data;
    }

    public Optional<HashMap<String, Object>> getProductDetail() {
        HashMap<String, Object> response = (this.productDetail.isPresent()) ? this.productDetail.get().data() : null;
        return Optional.ofNullable(response);
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = Optional.ofNullable(productDetail);
    }

    public Optional<List<HashMap<String, Object>>> getProductColors() {
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.productColors.isPresent()) {
            response = Optional.of(this.productColors.get().stream().map(color -> color.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public void addProductColorDetail(ProductColorDetails productColorDetails) {
        List<ProductColorDetails> productColorDetailsList =
                this.productColors.isEmpty() ? new ArrayList<>() : this.productColors.get();
        productColorDetailsList.add(productColorDetails);
        this.productColors = Optional.ofNullable(productColorDetailsList);
    }

    public void updateProductColorDetail(ProductColorDetails productColorDetails) {
        List<ProductColorDetails> productColorDetailsList = this.productColors.get();
        ProductColorDetails productColorDetailsActual = productColorDetailsList.stream().
                filter(color -> color.equalsProductColorId(productColorDetails)).findFirst().get();
        productColorDetailsList.remove(productColorDetailsActual);
        productColorDetailsList.add(productColorDetails);
        this.productColors = Optional.ofNullable(productColorDetailsList);
    }

    public ProductTotalSales getProductTotalSales() {
        return productTotalSales;
    }

    private Product(){}
}
