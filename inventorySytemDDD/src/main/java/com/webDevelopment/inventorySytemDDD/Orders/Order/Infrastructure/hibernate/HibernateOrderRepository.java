package com.webDevelopment.inventorySytemDDD.Orders.Order.Infrastructure.hibernate;

import com.webDevelopment.inventorySytemDDD.Orders.Order.Domain.Order;
import com.webDevelopment.inventorySytemDDD.Orders.Order.Domain.OrderId;
import com.webDevelopment.inventorySytemDDD.Orders.Order.Domain.OrderRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateOrderRepository implements OrderRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Order>  aggregateClass;

    public HibernateOrderRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Order.class;
    }

    @Override
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<Order> find(String OrderId) {
        OrderId id = new OrderId(OrderId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }
}
