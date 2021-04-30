package com.webDevelopment.inventorySytemDDD.Shared.Domain.Users;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.CustomUUID;

public class UserId extends CustomUUID {
    public UserId(String value) {
        super(value);
    }
    private UserId() {
        super();
    }
}
