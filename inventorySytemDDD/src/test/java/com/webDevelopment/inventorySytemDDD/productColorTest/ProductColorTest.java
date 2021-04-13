package com.webDevelopment.inventorySytemDDD.productColorTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Application.UpdateQuantity.ProductColorUpdateQuantity;
import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.Ports.ProductColorRepository;
import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ProductColor;
import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ValueObjects.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class ProductColorTest {

    @Test
    void should_update_quantity_productColor() {
        ProductColor productColor = new ProductColor(new ProductColorId("17b69c93-9fc1-476d-a143-051435f903dd"),
                new ProductId("d9942df6-c311-4bc5-8a02-e2797ea2dc82"),
                new ProductColorName("Blue"),
                new ProductColorQuantity(150d),
                new ProductColorIsStock(true),
                new ProductColorRBG("rgb(0,0,139)")
                );

        ProductColor updatedProductColor = new ProductColor(new ProductColorId("17b69c93-9fc1-476d-a143-051435f903dd"),
                new ProductId("d9942df6-c311-4bc5-8a02-e2797ea2dc82"),
                new ProductColorName("Blue"),
                new ProductColorQuantity(50d),
                new ProductColorIsStock(true),
                new ProductColorRBG("rgb(0,0,139)")
        );

        ProductColorRepository repository = mock(ProductColorRepository.class);
        Mockito.when(repository.find("17b69c93-9fc1-476d-a143-051435f903dd")).thenReturn(Optional.of(productColor));

        ProductColorUpdateQuantity useCase = new ProductColorUpdateQuantity(repository);

        useCase.execute("17b69c93-9fc1-476d-a143-051435f903dd", 100d, true);
        verify(repository, atLeastOnce()).update("17b69c93-9fc1-476d-a143-051435f903dd", updatedProductColor);
    }


}
