package com.webDevelopment.inventorySytemDDD.Users.User.Domain;

public class UserPassword
{
    private String value;

    public UserPassword(String value) {
        this.validate(value);
        this.value = value;
    }

    public String value() {
        return value;
    }

    private void validate(String value) {
        this.regexEvaluation(value);
    }

    private void regexEvaluation(String value) {
        //TODO: Evaluar el valor con un regex
    }
}
