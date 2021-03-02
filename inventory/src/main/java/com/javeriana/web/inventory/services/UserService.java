package com.javeriana.web.inventory.services;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public String getToken(String username);

}
