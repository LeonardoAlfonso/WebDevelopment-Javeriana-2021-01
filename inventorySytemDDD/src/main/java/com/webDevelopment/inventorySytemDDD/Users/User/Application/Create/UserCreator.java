package com.webDevelopment.inventorySytemDDD.Users.User.Application.Create;

import com.webDevelopment.inventorySytemDDD.Users.User.Domain.User;
import com.webDevelopment.inventorySytemDDD.Users.User.Domain.UserRepository;

public class UserCreator {
    private UserRepository repository;

    public UserCreator(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String userId, String userFirstName, String userLastName, String userNickName, String userPassword)
    {
        User user = new User(userId, userFirstName, userLastName, userNickName, userPassword);
        repository.save(user);
    }
}
