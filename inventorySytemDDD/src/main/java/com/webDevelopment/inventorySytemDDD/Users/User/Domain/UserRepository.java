package com.webDevelopment.inventorySytemDDD.Users.User.Domain;

import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Optional<User> find(String userId);

    void update(String userId, User user);
}