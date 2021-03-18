package com.webDevelopment.inventorySytemDDD.Users.User.Domain;

import java.util.Objects;

public class User {

    private String userId;
    private String userFirstName;
    private String userLastName;
    private String userNickName;
    private String userPassword;

    public User(String userId, String userFirstName, String userLastName, String userNickName, String userPassword) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userNickName = userNickName;
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userFirstName, user.userFirstName) &&
                Objects.equals(userLastName, user.userLastName) &&
                Objects.equals(userNickName, user.userNickName) &&
                Objects.equals(userPassword, user.userPassword);
    }
}
