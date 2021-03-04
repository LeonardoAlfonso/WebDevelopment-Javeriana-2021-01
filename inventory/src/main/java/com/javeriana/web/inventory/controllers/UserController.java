package com.javeriana.web.inventory.controllers;

import com.javeriana.web.inventory.models.Token;
import com.javeriana.web.inventory.models.User;
import com.javeriana.web.inventory.models.UserLogin;
import com.javeriana.web.inventory.services.UserService;
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
            if(this.userService.authentication(user.getUsername(), user.getPassword())) {
                String tokenJWT = this.userService.getToken(user.getUsername());
                token = new Token(tokenJWT);
                codigo = HttpStatus.OK;
            }
            else {
                codigo = HttpStatus.UNAUTHORIZED;
            }
        }
        catch (Exception e) {
            LOGGER.error("UserController.login Cause: " + e.getMessage());
        }
        return ResponseEntity.status(codigo).body(token);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUser(@RequestBody User user) {
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        try {
            user = this.userService.addUser(user);
            codigo = (user != null) ? HttpStatus.OK : HttpStatus.CONFLICT;
        }
        catch (Exception e) {
            LOGGER.error("UserController.addUser Cause: " + e.getMessage());
        }
        return ResponseEntity.status(codigo).body(null);
    }



}
