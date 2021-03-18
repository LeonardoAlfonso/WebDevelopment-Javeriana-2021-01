package com.webDevelopment.inventorySytemDDD.Users.User.Domain;

public class UserName
{
    private String value;

    public UserName(String value) {
        this.validate(value);
        this.value = value;
    }

    public String value() {
        return value;
    }

    private void validate(String value) {
        this.lenghtRule(value);
        //TODO: Other Rules
    }

    private void lenghtRule(String value) {
        if (value.length() < 3) {
//            throw new Exception("Number of characters invalid");
        }
    }
}
