package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Application.Create;

import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.Ports.ProductColorRepository;
import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ProductColor;
import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ValueObjects.ProductColorIsStock;
import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ValueObjects.ProductColorName;
import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ValueObjects.ProductColorQuantity;
import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ValueObjects.ProductColorRBG;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event.EventBus;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductColorId;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductId;

public class ProductColorCreator {

    private ProductColorRepository repository;
    private EventBus eventBus;

    public ProductColorCreator(ProductColorRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(String productColorId, String productId,
                        String productColorName, double productColorQuantity,
                        boolean productColorIsStock, String productColorRBG) {
        ProductColor productColor = ProductColor.create(new ProductColorId(productColorId),
                new ProductId(productId), new ProductColorName(productColorName),
                new ProductColorQuantity(productColorQuantity), new ProductColorIsStock(productColorIsStock),
                new ProductColorRBG(productColorRBG));
        repository.save(productColor);
        this.eventBus.publish(productColor.pullDomainEvents());
    }
}
