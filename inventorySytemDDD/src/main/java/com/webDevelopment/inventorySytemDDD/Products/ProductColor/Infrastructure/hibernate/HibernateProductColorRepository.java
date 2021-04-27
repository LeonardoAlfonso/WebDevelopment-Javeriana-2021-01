package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Infrastructure.hibernate;

import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.Ports.ProductColorRepository;
import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ProductColor;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductColorId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateProductColorRepository implements ProductColorRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<ProductColor>  aggregateClass;

    public HibernateProductColorRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = ProductColor.class;
    }

    @Override
    public void update(ProductColor productColor) {
        this.sessionFactory.getCurrentSession().update(productColor);
    }

    @Override
    public Optional<ProductColor> find(String productColorId) {
        ProductColorId id = new ProductColorId(productColorId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(ProductColor productColor) {
        sessionFactory.getCurrentSession().save(productColor);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }
}
