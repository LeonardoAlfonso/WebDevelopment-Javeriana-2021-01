package com.webDevelopment.inventorySytemDDD.Products.Product.Application.AddProductDetail;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Exceptions.ProductNotExist;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Ports.ProductRepository;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Product;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductDetail;

import java.util.Optional;

public class ProductAddProductDetail {

    private ProductRepository repository;

    public ProductAddProductDetail(ProductRepository repository) {
        this.repository = repository;
    }

    public void execute(String productId, String productDetailId, String productDetailDescription) {
        Optional<Product> product = this.repository.find(productId);
        if(product.isEmpty()) {
            throw new ProductNotExist("The product " + productId + " not exists.");
        }
        Product finalProduct = product.get();
        finalProduct.setProductDetail(new ProductDetail(productDetailId, productDetailDescription));
        repository.update(finalProduct);
    }


}
