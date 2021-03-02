package com.javeriana.web.inventory.controllers;

import com.javeriana.web.inventory.models.Product;
import com.javeriana.web.inventory.models.Token;
import com.javeriana.web.inventory.models.UserLogin;
import com.javeriana.web.inventory.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.javeriana.web.inventory.InventoryApplication.LOGGER;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Token> login(@RequestBody UserLogin user) {
        Token token = null;
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        try {
            String tokenJWT = this.userService.getToken(user.getUsername());
            token = new Token(tokenJWT);
            codigo = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("UserController.login Cause: " + e.getMessage());
        }
        return ResponseEntity.status(codigo).body(token);
    }



}
