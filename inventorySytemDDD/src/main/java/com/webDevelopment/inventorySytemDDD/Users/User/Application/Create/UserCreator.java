package com.webDevelopment.inventorySytemDDD.Users.User.Application.Create;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.Users.UserId;
import com.webDevelopment.inventorySytemDDD.Users.User.Domain.*;

public class UserCreator {
    private UserRepository repository;
    private ValidateWordService service;
    private UserValidateWords validator;
    private UserDomainFinder finder;

    public UserCreator(UserRepository repository, ValidateWordService service) {
        this.repository = repository;
        this.service = service;
        this.validator = new UserValidateWords(service);
        this.finder = new UserDomainFinder(repository);
    }

    public void execute(String userId, String userFirstName, String userLastName, String userNickName, String userPassword)
    {
        this.validate(userId);
        validator.execute(new UserNickName(userNickName).value());
        User user = new User(new UserId(userId), new UserName(userFirstName), new UserLastName(userLastName) , new UserNickName(userNickName),new UserPassword(userPassword));
        repository.save(user);
    }

    private void validate(String UserId)
    {
        try
        {
            this.finder.execute(UserId);

        }
        catch (UserNotExist exception) { }
    }
}
