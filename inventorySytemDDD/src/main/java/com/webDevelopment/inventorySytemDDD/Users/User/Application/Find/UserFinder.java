package com.webDevelopment.inventorySytemDDD.Users.User.Application.Find;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.Users.UserId;
import com.webDevelopment.inventorySytemDDD.Users.User.Domain.*;

import java.util.Optional;

public class UserFinder {

    private UserDomainFinder finder;

    public UserFinder(UserRepository repository) {
        this.finder = new UserDomainFinder(repository);
    }

    public User execute(String userId) {
        Optional<User> user = finder.execute(new UserId(userId).value());
        return user.get();
    }
}
