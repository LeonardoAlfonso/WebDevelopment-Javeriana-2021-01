package com.webDevelopment.inventorySytemDDD.orderTests.unit;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.webDevelopment.inventorySytemDDD.Orders.Order.Application.Create.Sale.SaleOrderCreator;
import com.webDevelopment.inventorySytemDDD.Orders.Order.Domain.*;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductColorId;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Products.ProductId;
import com.webDevelopment.inventorySytemDDD.Shared.Domain.Users.UserId;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderTests {

    @Test
    void should_create_sale_order() {
        OrderRepository repository = mock(OrderRepository.class);
        Order order = new Order(new OrderId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"), new ProductColorId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432742"),
                                new UserId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432763"), new ProductId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432788"),
                                new OrderQuantity(45), new OrderIsSale(true), new OrderTotal(450000d));

        SaleOrderCreator creator = new SaleOrderCreator(repository);

        creator.execute("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721", "bb5f8ac3-b90d-40ec-b3e2-e0ca3f432788",
                  "bb5f8ac3-b90d-40ec-b3e2-e0ca3f432742", "bb5f8ac3-b90d-40ec-b3e2-e0ca3f432763",
                                45, 450000d);

        verify(repository, atLeastOnce()).save(order);
    }
}