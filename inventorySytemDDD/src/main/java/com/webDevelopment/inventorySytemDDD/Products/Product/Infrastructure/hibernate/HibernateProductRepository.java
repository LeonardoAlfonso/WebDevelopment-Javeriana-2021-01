package com.webDevelopment.inventorySytemDDD.Products.Product.Infrastructure.hibernate;

import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Ports.ProductRepository;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Product;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductId;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateProductRepository implements ProductRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Product>  aggregateClass;

    public HibernateProductRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Product.class;
    }

    @Override
    public void update(String productId, Product product) {

    }

    @Override
    public Optional<Product> find(String productId) {
        ProductId id = new ProductId(productId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(Product product) {
        sessionFactory.getCurrentSession().save(product);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Product>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("From Product");
        return Optional.ofNullable(query.list());
    }
}
