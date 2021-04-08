package com.webDevelopment.inventorySytemDDD.Users.User.Application.Find;

import com.webDevelopment.inventorySytemDDD.Users.Shared.Application.Response;
import com.webDevelopment.inventorySytemDDD.Users.User.Domain.User;

import java.util.HashMap;

public class UserFinderResponse implements Response {

    private User user;

    public UserFinderResponse(User user) {
        this.user = user;
    }

    public HashMap response()
    {
        HashMap response = this.user.data();
        response.remove("id");
        return response;
    }
}
