package com.webDevelopment.inventorySytemDDD.Users.User.Domain;

import com.webDevelopment.inventorySytemDDD.Users.Shared.Domain.CustomUUID;

public class UserId extends CustomUUID {
    public UserId(String value) {
        super(value);
    }
}
