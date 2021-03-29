package com.webDevelopment.inventorySytemDDD.Users.Shared.Domain;

public class UUIDNotValid extends RuntimeException {
    public UUIDNotValid(String message) {
        super(message);
    }
}
