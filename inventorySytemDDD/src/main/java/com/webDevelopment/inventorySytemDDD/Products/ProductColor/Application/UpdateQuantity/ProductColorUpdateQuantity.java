package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Application.UpdateQuantity;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Exceptions.ProductColorNotExist;
import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.Ports.ProductColorRepository;
import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ProductColor;
import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ValueObjects.ProductColorQuantity;

import java.util.Optional;

public class ProductColorUpdateQuantity {

    private ProductColorRepository repository;

    public ProductColorUpdateQuantity(ProductColorRepository repository) {
        this.repository = repository;
    }

    public void execute(String productColorId, Double quantity, Boolean isSale)  {

        Optional<ProductColor> productColorOptional = this.repository.find(productColorId);
        if (productColorOptional.isEmpty())
        {
            throw new ProductColorNotExist("The product color " + productColorId + " not exists");
        }
        ProductColor productColor = productColorOptional.get();
        if(isSale) {
            productColor.saleProductColor(new ProductColorQuantity(quantity));
        }
        else {
            productColor.buyProductColor(new ProductColorQuantity(quantity));
        }
        this.repository.update(productColor);
    }

}
