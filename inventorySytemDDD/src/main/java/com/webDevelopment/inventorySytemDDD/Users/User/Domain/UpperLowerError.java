package com.webDevelopment.inventorySytemDDD.Users.User.Domain;

public class UpperLowerError extends RuntimeException {
    public UpperLowerError(String message) {
        super(message);
    }
}
