package com.webDevelopment.inventorySytemDDD.Products.Product.Infrastructure.Controllers;

import com.webDevelopment.inventorySytemDDD.Products.Product.Application.AddProductColor.ProductAddProductColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class CreateProductColorPostController {

    @Autowired
    private ProductAddProductColor productAddProductColor;

    @PostMapping(value="/addProductColor")
    public ResponseEntity<List<HashMap>> execute(@RequestBody Request request)
    {
        productAddProductColor.execute(request.getIdProduct(), request.getIdProductColor());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class Request {
        private String idProductColor;
        private String idProduct;

        public Request() {}

        public String getIdProductColor() {
            return idProductColor;
        }

        public void setIdProductColor(String idProductColor) {
            this.idProductColor = idProductColor;
        }

        public String getIdProduct() {
            return idProduct;
        }

        public void setIdProduct(String idProduct) {
            this.idProduct = idProduct;
        }
    }

}
