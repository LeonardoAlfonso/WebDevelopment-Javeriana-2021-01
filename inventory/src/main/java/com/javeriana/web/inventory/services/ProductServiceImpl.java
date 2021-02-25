package com.javeriana.web.inventory.services;

import com.javeriana.web.inventory.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.javeriana.web.inventory.InventoryApplication.LOGGER;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product addProduct(Product product) throws Exception {
        try {
            product = this.repository.save(product);
        }
        catch (Exception e) {
            LOGGER.error("ProductServiceImpl.addProduct Causa: " + e.toString());
            throw new Exception("ProductServiceImpl.addProduct Causa: " + e.toString());
        }
        return product;
    }

    @Override
    public Product getProduct(long id) throws Exception {
        Product product = null;
        try {
            product = this.repository.findById(id).get();
        }
        catch (Exception e) {
            LOGGER.error("ProductServiceImpl.getProduct Causa: " + e.toString());
            throw new Exception("ProductServiceImpl.getProduct Causa: " + e.toString());
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) throws Exception {

    }

    @Override
    public void deleteProduct(long id) throws Exception {

    }

    @Override
    public List<Product> getAllProducts() throws Exception {
        List<Product> products = null;
        try {
            products = this.repository.findAll();
        }
        catch (Exception e) {
            LOGGER.error("ProductServiceImpl.getAllProducts Causa: " + e.toString());
            throw new Exception("ProductServiceImpl.getAllProducts Causa: " + e.toString());
        }
        return products;
    }
}
