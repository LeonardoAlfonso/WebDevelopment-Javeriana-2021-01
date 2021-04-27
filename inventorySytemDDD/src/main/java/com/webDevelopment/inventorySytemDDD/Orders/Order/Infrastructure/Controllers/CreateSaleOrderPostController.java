package com.webDevelopment.inventorySytemDDD.Orders.Order.Infrastructure.Controllers;

import com.webDevelopment.inventorySytemDDD.Orders.Order.Application.Create.Sale.SaleOrderCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class CreateSaleOrderPostController {

    @Autowired
    private SaleOrderCreator creator;

    @PostMapping(value = "/createSale", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request) {
        creator.execute(request.getId(), request.getIdProduct(), request.getIdProductColor(), request.getIdUser(), request.getQuantity(), request.getTotal());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class Request {
        private String id;
        private String idProductColor;
        private String idUser;
        private String idProduct;
        private int quantity;
        private double total;

        public Request() {}

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIdProductColor() {
            return idProductColor;
        }

        public void setIdProductColor(String idProductColor) {
            this.idProductColor = idProductColor;
        }

        public String getIdUser() {
            return idUser;
        }

        public void setIdUser(String idUser) {
            this.idUser = idUser;
        }

        public String getIdProduct() {
            return idProduct;
        }

        public void setIdProduct(String idProduct) {
            this.idProduct = idProduct;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }
    }

}
