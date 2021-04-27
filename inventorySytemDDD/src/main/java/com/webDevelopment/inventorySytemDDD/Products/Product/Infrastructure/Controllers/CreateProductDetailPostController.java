package com.webDevelopment.inventorySytemDDD.Products.Product.Infrastructure.Controllers;

import com.webDevelopment.inventorySytemDDD.Products.Product.Application.AddProductDetail.ProductAddProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class CreateProductDetailPostController {

    @Autowired
    private ProductAddProductDetail creator;

    @PostMapping(value = "/addProductDetail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request) {
        creator.execute(request.productId, request.productDetailId, request.productDetailDescription);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class Request {
        private String productId;
        private String productDetailId;
        private String productDetailDescription;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductDetailId() {
            return productDetailId;
        }

        public void setProductDetailId(String productDetailId) {
            this.productDetailId = productDetailId;
        }

        public String getProductDetailDescription() {
            return productDetailDescription;
        }

        public void setProductDetailDescription(String productDetailDescription) {
            this.productDetailDescription = productDetailDescription;
        }

        public Request() { }
    }

}
