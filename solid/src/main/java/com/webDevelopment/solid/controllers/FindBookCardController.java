package com.webDevelopment.solid.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindBookCardController {

    @RequestMapping("/healthCheck")
    public String healthCkeck() {
        return "Server up";
    }
}
