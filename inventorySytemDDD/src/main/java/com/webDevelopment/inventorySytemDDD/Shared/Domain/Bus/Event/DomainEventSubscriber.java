package com.webDevelopment.inventorySytemDDD.Shared.Domain.Bus.Event;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface DomainEventSubscriber {
    Class<? extends DomainEvent>[] value();
}



/*
* @DomainEventSubscriber({OrderCreatedDomainEvent.class})
* public class UpdateQuantityOnOrderCreated {
*
*   @EventListener
*   public void on(OrderCreatedDomainEvent event) {
*   .................
*   }
*
* }
*
*
* */