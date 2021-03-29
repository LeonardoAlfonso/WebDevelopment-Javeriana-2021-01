package com.webDevelopment.inventorySytemDDD.Users.User.Application.Create;

import com.webDevelopment.inventorySytemDDD.Users.User.Domain.*;

public class UserCreator {
    private UserRepository repository;
    private ValidateWordService service;
    private UserValidateWords validator;

    public UserCreator(UserRepository repository, ValidateWordService service) {
        this.repository = repository;
        this.service = service;
        this.validator = new UserValidateWords(service);
    }

    public void execute(String userId, String userFirstName, String userLastName, String userNickName, String userPassword)
    {
        validator.execute(userNickName);
        User user = new User(new UserId(userId), new UserName(userFirstName), new UserLastName(userLastName) , new UserNickName(userNickName), new UserPassword(userPassword));
        repository.save(user);
    }
}
