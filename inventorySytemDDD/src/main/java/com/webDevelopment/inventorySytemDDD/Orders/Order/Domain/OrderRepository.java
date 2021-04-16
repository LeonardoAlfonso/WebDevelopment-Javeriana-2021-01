package com.webDevelopment.inventorySytemDDD.Orders.Order.Domain;

import java.util.Optional;

public interface OrderRepository {

    void save(Order order);
    Optional<Order> find (String OrderId);
}
