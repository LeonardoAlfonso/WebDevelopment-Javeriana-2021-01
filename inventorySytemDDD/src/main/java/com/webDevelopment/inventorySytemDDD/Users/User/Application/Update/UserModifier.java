package com.webDevelopment.inventorySytemDDD.Users.User.Application.Update;

import com.webDevelopment.inventorySytemDDD.Users.User.Domain.User;
import com.webDevelopment.inventorySytemDDD.Users.User.Domain.UserDomainFinder;
import com.webDevelopment.inventorySytemDDD.Users.User.Domain.UserRepository;

import java.util.Optional;

public class UserModifier {

    private UserRepository repository;
    private UserDomainFinder finder;

    public UserModifier(UserRepository repository) {
        this.repository = repository;
        this.finder = new UserDomainFinder(repository);
    }

    public User execute(String userId, User user) {
        Optional<User> actualUser = finder.execute(userId);
        return repository.update(userId, user);
    }
}
