package com.webDevelopment.inventorySytemDDD.Users.User.Domain;

public class NotSymbolsFound extends RuntimeException {
    public NotSymbolsFound(String message) {
        super(message);
    }
}
