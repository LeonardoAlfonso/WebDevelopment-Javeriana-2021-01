package com.webDevelopment.inventorySytemDDD.Products.Product.Application.Find;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Product;
import com.webDevelopment.inventorySytemDDD.Shared.Application.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ProductFinderResponse implements Response {

    private final Product product;
    private HashMap<String, Object> response;

    public ProductFinderResponse(Product product) {
        this.product = product;
    }

    @Override
    public HashMap<String, Object> response() {
        this.response = product.data();
        this.setDetail();
        this.setColors();
        return response;
    }

    private void setDetail() {
        Optional<HashMap<String, Object>> detail = this.product.getProductDetail();
        if(detail.isPresent()) {
            detail.ifPresent(objectDetail -> response.put("detail", objectDetail));
        }
        else {
            response.put("detail", null);
        }
    }

    private void setColors() {
        Optional<List<HashMap<String, Object>>> colors = this.product.getProductColors();
        if(colors.isPresent()) {
            colors.ifPresent(colorList -> response.put("colors", colorList));
        }
        else {
            response.put("colors", null);
        }
    }

}


