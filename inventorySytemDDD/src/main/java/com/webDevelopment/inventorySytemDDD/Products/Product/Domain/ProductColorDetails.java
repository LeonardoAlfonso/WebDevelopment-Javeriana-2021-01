package com.webDevelopment.inventorySytemDDD.Products.Product.Domain;

import java.util.HashMap;

public class ProductColorDetails {

    private String ProductColorId;
    private String Name;
    private Integer Quantity;
    private Boolean HasStock;
    private String RGB;

    public ProductColorDetails(String productColorId, String name, Integer quantity, Boolean hasStock, String RGB) {
        ProductColorId = productColorId;
        Name = name;
        Quantity = quantity;
        this.HasStock = hasStock;
        this.RGB = RGB;
    }

    public HashMap<String, Object> data()
    {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", ProductColorId);
            put("name", Name);
            put("quantity", Quantity);
            put("hasStock", HasStock);
            put("rgb", RGB);
        }};
        return data;
    }
}



