package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain;

import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.Exceptions.NotAvailableBalance;
import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ValueObjects.*;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Aggregate.AggregateRoot;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductColorCreatedDomainEvent;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductColorId;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductColorUpdatedDomainEvent;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductId;

import java.util.HashMap;
import java.util.Objects;

public class ProductColor extends AggregateRoot {

    private ProductColorId productColorId;
    private ProductId productId;
    private ProductColorName productColorName;
    private ProductColorQuantity productColorQuantity;
    private ProductColorIsStock productColorIsStock;
    private ProductColorRBG productColorRBG;

    public ProductColor(ProductColorId productColorId,
                        ProductId productId,
                        ProductColorName productColorName,
                        ProductColorQuantity productColorQuantity,
                        ProductColorIsStock productColorIsStock,
                        ProductColorRBG productColorRBG)
    {
        this.productColorId = productColorId;
        this.productId = productId;
        this.productColorName = productColorName;
        this.productColorQuantity = productColorQuantity;
        this.productColorIsStock = productColorIsStock;
        this.productColorRBG = productColorRBG;
    }

    public static ProductColor create(ProductColorId productColorId,
                               ProductId productId,
                               ProductColorName productColorName,
                               ProductColorQuantity productColorQuantity,
                               ProductColorIsStock productColorIsStock,
                               ProductColorRBG productColorRBG) {
        ProductColor productColor = new ProductColor(productColorId, productId, productColorName, productColorQuantity, productColorIsStock, productColorRBG);
        productColor.record(new ProductColorCreatedDomainEvent(productId.value(), productColorId.value(),
                productColorName.value(), productColorQuantity.value(), productColorIsStock.value(),
                productColorRBG.value()));
        return productColor;
    }

    public void saleProductColor(ProductColorQuantity productColorQuantity) {
        int result = this.productColorQuantity.value().compareTo(productColorQuantity.value());
        if(result < 0) {
            throw new NotAvailableBalance("The Balance is not Available.");
        }
        Double newQuantity = this.productColorQuantity.value() - productColorQuantity.value();
        this.productColorQuantity = new ProductColorQuantity(newQuantity);
        if(result == 0) {
            this.changeIsStock(false);
        }
        this.record(new ProductColorUpdatedDomainEvent(this.productId.value(),
                this.productColorId.value(), this.productColorName.value(),
                this.productColorQuantity.value(), this.productColorIsStock.value(),
                this.productColorRBG.value()));
    }

    public void buyProductColor(ProductColorQuantity productColorQuantity) {
        Double newQuantity = this.productColorQuantity.value() + productColorQuantity.value();
        this.productColorQuantity = new ProductColorQuantity(newQuantity);
        int result = this.productColorQuantity.value().compareTo(0d);
        if(result >= 0) {
            this.changeIsStock(true);
        }
        this.record(new ProductColorUpdatedDomainEvent(this.productId.value(),
                this.productColorId.value(), this.productColorName.value(),
                this.productColorQuantity.value(), this.productColorIsStock.value(),
                this.productColorRBG.value()));
    }

    private void changeIsStock(Boolean newValue) {
        this.productColorIsStock = new ProductColorIsStock(newValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductColor that = (ProductColor) o;
        return Objects.equals(productColorId, that.productColorId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productColorName, that.productColorName) &&
                Objects.equals(productColorQuantity, that.productColorQuantity) &&
                Objects.equals(productColorIsStock, that.productColorIsStock) &&
                Objects.equals(productColorRBG, that.productColorRBG);
    }

    public HashMap<String, String> data()
    {
        HashMap<String, String> data = new HashMap<String, String>() {{
            put("id", productId.value());
            put("idProduct", productId.value());
            put("name", productColorName.value());
            put("quantity", productColorQuantity.value().toString());
            put("isStock", productColorIsStock.value().toString());
            put("rgb", productColorRBG.value());
        }};
        return data;
    }

    private ProductColor(){}
}
