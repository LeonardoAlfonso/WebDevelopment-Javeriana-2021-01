package com.webDevelopment.solid.services;

public class JsonFormatter implements Formatter {
    @Override
    public String Format(String message) {
        return "{ 'bookCard' : '" + message + "' }";
    }
}
