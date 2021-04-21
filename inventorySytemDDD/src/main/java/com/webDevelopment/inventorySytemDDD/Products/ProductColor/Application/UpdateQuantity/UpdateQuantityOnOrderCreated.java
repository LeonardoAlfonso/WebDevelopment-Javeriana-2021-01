package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Application.UpdateQuantity;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Orders.OrderCreatedDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({OrderCreatedDomainEvent.class})
public final class UpdateQuantityOnOrderCreated {

    private final ProductColorUpdateQuantity productColorUpdateQuantity;

    public UpdateQuantityOnOrderCreated(ProductColorUpdateQuantity productColorUpdateQuantity) {
        this.productColorUpdateQuantity = productColorUpdateQuantity;
    }

    @EventListener
    public void on(OrderCreatedDomainEvent event) {
        this.productColorUpdateQuantity.execute(event.aggregateId(), event.getQuantity(), event.isSale());
    }

}
