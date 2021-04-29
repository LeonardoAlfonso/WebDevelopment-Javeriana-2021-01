package com.webDevelopment.inventorySytemDDD.Products.Product.Infrastructure.DomainEventSubscribers;

import com.webDevelopment.inventorySytemDDD.Products.Product.Application.UpdateProductColor.ProductUpdateProductColor;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductColorUpdatedDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({ProductColorUpdatedDomainEvent.class})
public final class UpdateProductColorOnProductColorUpdated {

    private ProductUpdateProductColor productUpdateProductColor;

    public UpdateProductColorOnProductColorUpdated(ProductUpdateProductColor productUpdateProductColor) {
        this.productUpdateProductColor = productUpdateProductColor;
    }

    @EventListener
    public void on(ProductColorUpdatedDomainEvent event) {
        this.productUpdateProductColor.execute(event.aggregateId(), event.getProductColorId(),
                event.getName(), event.getQuantity(), event.isHasStock(), event.getRgb());
    }

}
