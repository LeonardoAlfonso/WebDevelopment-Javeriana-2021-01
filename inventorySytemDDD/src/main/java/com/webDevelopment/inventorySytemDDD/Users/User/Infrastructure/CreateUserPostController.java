package com.webDevelopment.inventorySytemDDD.Users.User.Infrastructure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public final class CreateUserPostController {


//    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String execute(@RequestBody Request request) {
//        //TODO: Write Logic
//        return "";
//    }

//    @GetMapping(value="/test/{nickname}")
//    public void sendRequest(@PathVariable("nickname") String nickname)
//    {
//
//    }
}

