package com.webDevelopment.inventorySytemDDD.Products.ProductColor.Infrastructure.Controllers;

import com.webDevelopment.inventorySytemDDD.Products.ProductColor.Application.Create.ProductColorCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/productColors")
public class CreateProductColorPostController {

    @Autowired
    private ProductColorCreator productColorCreator;

    @PostMapping(value="/create")
    public ResponseEntity<List<HashMap>> execute(@RequestBody Request request)
    {
        productColorCreator.execute(request.getProductId(), request.getProductColorId(), request.getName(),
                request.getQuantity(), request.isHasStock(), request.getRgb());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class Request {
        private String productId;
        private String productColorId;
        private String name;
        private double quantity;
        private boolean hasStock;
        private String rgb;

        public Request() {}

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductColorId() {
            return productColorId;
        }

        public void setProductColorId(String productColorId) {
            this.productColorId = productColorId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getQuantity() {
            return quantity;
        }

        public void setQuantity(double quantity) {
            this.quantity = quantity;
        }

        public boolean isHasStock() {
            return hasStock;
        }

        public void setHasStock(boolean hasStock) {
            this.hasStock = hasStock;
        }

        public String getRgb() {
            return rgb;
        }

        public void setRgb(String rgb) {
            this.rgb = rgb;
        }
    }

}

