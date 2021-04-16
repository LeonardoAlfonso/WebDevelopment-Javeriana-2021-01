package com.webDevelopment.inventorySytemDDD.Orders.Order.Domain;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductColorId;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductId;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Users.UserId;

import java.util.HashMap;
import java.util.Objects;

public class Order {
    private OrderId orderId;
    private ProductColorId productColorId;
    private UserId userId;
    private ProductId productId;
    private OrderQuantity quantity;
    private OrderIsSale isSale;
    private OrderTotal total;

    public Order(
            OrderId orderId,
            ProductColorId productColorId,
            UserId userId,
            ProductId productId,
            OrderQuantity quantity,
            OrderIsSale isSale,
            OrderTotal total
    ) {
        this.orderId = orderId;
        this.productColorId = productColorId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.isSale = isSale;
        this.total = total;
    }

    public static Order createSaleOrder(OrderId orderId, ProductColorId productColorId, UserId userId, ProductId productId, OrderQuantity quantity,
                       OrderTotal total)
    {
        Order order = new Order (orderId, productColorId, userId, productId, quantity, new OrderIsSale(true), total);
        //TODO: Record evento de orden creada
        return order;
    }

    public static Order createBuyOrder(OrderId orderId, ProductColorId productColorId, UserId userId, ProductId productId, OrderQuantity quantity,
                                        OrderTotal total)
    {
        Order order = new Order (orderId, productColorId, userId, productId, quantity, new OrderIsSale(false), total);
        //TODO: Record evento de orden creada
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
//        Boolean x = Objects.equals(orderId, order.orderId);
//        Boolean y = Objects.equals(productColorId, order.productColorId);
//        Boolean z = Objects.equals(userId, order.userId);
////        Boolean v = Objects.equals(productId, order.productId);
////        Boolean w = Objects.equals(quantity, order.quantity);
////        Boolean t = Objects.equals(isSale, order.isSale);
////        Boolean s = Objects.equals(total, order.total);
////
////
//
//
        return Objects.equals(orderId, order.orderId) &&
                Objects.equals(productColorId, order.productColorId) &&
                Objects.equals(userId, order.userId) &&
                Objects.equals(productId, order.productId) &&
                Objects.equals(quantity, order.quantity) &&
                Objects.equals(isSale, order.isSale) &&
                Objects.equals(total, order.total);
    }

    public HashMap<String, String> data()
    {
        HashMap<String, String> data = new HashMap<String, String>() {{
            put("id", productId.value());
            put("idProduct", productId.value());
            put("idProductColor", productColorId.value());
            put("quantity", quantity.value().toString());
            put("isSale", isSale.value().toString());
            put("total", total.value().toString());
        }};
        return data;
    }

    public Order() {
    }
}
