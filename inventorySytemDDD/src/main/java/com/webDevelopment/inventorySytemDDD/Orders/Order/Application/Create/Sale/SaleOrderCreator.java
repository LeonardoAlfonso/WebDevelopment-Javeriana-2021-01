package com.webDevelopment.inventorySytemDDD.Orders.Order.Application.Create.Sale;

import com.webDevelopment.inventorySytemDDD.Orders.Order.Domain.*;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductColorId;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductId;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Users.UserId;

public class SaleOrderCreator {

    private OrderRepository repository;
    //TODO: Inject Event Bus


    public SaleOrderCreator(OrderRepository repository) {
        this.repository = repository;
    }

    public void execute(String orderId, String productId, String productColorId, String userId, Integer quantity, Double total)
    {
        Order order = Order.createSaleOrder(new OrderId(orderId), new ProductColorId(productColorId), new UserId(userId), new ProductId(productId),
                new OrderQuantity(quantity), new OrderTotal(total));
        this.repository.save(order);
        //TODO: Lanzar Eventos de order
    }

}
