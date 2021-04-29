package com.webDevelopment.inventorySytemDDD.Products.Product.Infrastructure.DomainEventSubscribers;

import com.webDevelopment.inventorySytemDDD.Products.Product.Application.AddProductColor.ProductAddProductColor;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductColorCreatedDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({ProductColorCreatedDomainEvent.class})
public class AddProductColorOnProductColorCreated {

    private ProductAddProductColor productAddProductColor;

    public AddProductColorOnProductColorCreated(ProductAddProductColor productAddProductColor) {
        this.productAddProductColor = productAddProductColor;
    }

    @EventListener
    public void on(ProductColorCreatedDomainEvent event) {
        this.productAddProductColor.execute(event.aggregateId(), event.getProductColorId(),
                event.getName(), event.getQuantity(), event.isHasStock(), event.getRgb());
    }
}
