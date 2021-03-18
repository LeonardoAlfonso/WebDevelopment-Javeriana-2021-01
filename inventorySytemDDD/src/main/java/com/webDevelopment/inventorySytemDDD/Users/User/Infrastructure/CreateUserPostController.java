package com.webDevelopment.inventorySytemDDD.Users.User.Infrastructure;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public final class CreateUserPostController {


    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public String execute(@RequestBody Request request) {
        //TODO: Write Logic
        return "";
    }
}

final class Request
{
    private String name;
    private String password;

    public String getname() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
