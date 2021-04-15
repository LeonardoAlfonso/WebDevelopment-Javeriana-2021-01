package com.webDevelopment.inventorySytemDDD.Products.Product.Infrastructure.Controllers;

import com.webDevelopment.inventorySytemDDD.Products.Product.Application.All.ProductAll;
import com.webDevelopment.inventorySytemDDD.Products.Product.Application.All.ProductAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class AllProductsGetController {

    @Autowired
    private ProductAll productAll;

    @GetMapping(value="/")
    public ResponseEntity<List<HashMap>> execute()
    {
        ProductAllResponse response = new ProductAllResponse(productAll.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

}
