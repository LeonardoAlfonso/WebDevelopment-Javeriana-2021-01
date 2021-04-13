package com.webDevelopment.inventorySytemDDD.productTest.unit;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.webDevelopment.inventorySytemDDD.Products.Product.Application.AddBalance.ProductBalanceAdder;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Ports.ProductRepository;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.Product;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductId;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductName;
import com.webDevelopment.inventorySytemDDD.Products.Product.Domain.ValueObjects.ProductTotalSales;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductTest {

    @Test
    void should_update_balance_product() {
//        Product product = new Product(new ProductId("17b69c93-9fc1-476d-a143-051435f903dd"), new ProductName("Tela"), new ProductTotalSales(89d));
//        Product updatedProduct = new Product(new ProductId("17b69c93-9fc1-476d-a143-051435f903dd"), new ProductName("Tela"), new ProductTotalSales(189d));
//
//        ProductRepository repository = mock(ProductRepository.class);
//        Mockito.when(repository.find("17b69c93-9fc1-476d-a143-051435f903dd")).thenReturn(Optional.of(product));
//
//        ProductBalanceAdder adder = new ProductBalanceAdder(repository);
//
//        adder.execute("17b69c93-9fc1-476d-a143-051435f903dd", 100d);
//
//        verify(repository, atLeastOnce()).update("17b69c93-9fc1-476d-a143-051435f903dd", updatedProduct);
    }
}
