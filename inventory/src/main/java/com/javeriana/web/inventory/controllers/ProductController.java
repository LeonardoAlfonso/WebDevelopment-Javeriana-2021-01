package com.javeriana.web.inventory.controllers;

import com.javeriana.web.inventory.models.Product;
import com.javeriana.web.inventory.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.javeriana.web.inventory.InventoryApplication.LOGGER;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = null;
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        try {
            products = this.productService.getAllProducts();
            codigo = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("ProductController.getProducts Cause: " + e.getMessage());
        }
        return ResponseEntity.status(codigo).body(products);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        long id = 0;
        try {
            product = this.productService.addProduct(product);
            codigo = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("ProductController.addProduct Cause: " + e.getMessage());
        }
        return ResponseEntity.status(codigo).body(product);
    }
}
