package com.javeriana.web.inventory.services;

import com.javeriana.web.inventory.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public Product addProduct(Product product) throws Exception;
    public Product getProduct(long id) throws Exception;
    public void updateProduct(Product product) throws Exception;
    public void deleteProduct(long id) throws Exception;
    public List<Product> getAllProducts() throws Exception;
}
