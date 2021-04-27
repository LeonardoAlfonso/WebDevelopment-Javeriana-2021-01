package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Infrastructure.Controllers;

import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Application.Find.ProductColorFinder;
import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Domain.ProductColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/productColors")
public class FindProductColorByIdController {

    @Autowired
    private ProductColorFinder finder;

    @GetMapping(value="find/{id}")
    public ResponseEntity<HashMap> execute(@PathVariable("id") String id)
    {
        ProductColor productColor = finder.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(productColor.data());
    }
}