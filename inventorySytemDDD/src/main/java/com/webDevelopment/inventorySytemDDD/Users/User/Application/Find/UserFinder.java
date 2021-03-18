package com.webDevelopment.inventorySytemDDD.Users.User.Application.Find;

import com.webDevelopment.inventorySytemDDD.Users.User.Domain.User;
import com.webDevelopment.inventorySytemDDD.Users.User.Domain.UserDomainFinder;
import com.webDevelopment.inventorySytemDDD.Users.User.Domain.UserNotExist;
import com.webDevelopment.inventorySytemDDD.Users.User.Domain.UserRepository;

import java.util.Optional;

public class UserFinder {

    private UserDomainFinder finder;

    public UserFinder(UserRepository repository) {
        this.finder = new UserDomainFinder(repository);
    }

    public User execute(String userId) {
        Optional<User> user = finder.execute(userId);
        return user.get();
    }
}
