package com.webDevelopment.inventorySytemDDD.Users.User.Domain;

public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists(String message) {
        super(message);
    }
}
