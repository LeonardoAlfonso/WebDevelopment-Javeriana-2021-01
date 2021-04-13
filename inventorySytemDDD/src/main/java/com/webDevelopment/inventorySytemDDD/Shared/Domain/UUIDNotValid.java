package com.webDevelopment.inventorySytemDDD.Shared.Domain;

public class UUIDNotValid extends RuntimeException {
    public UUIDNotValid(String message) {
        super(message);
    }
}
