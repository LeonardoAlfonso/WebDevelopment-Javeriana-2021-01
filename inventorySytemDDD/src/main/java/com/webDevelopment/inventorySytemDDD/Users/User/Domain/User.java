package com.webDevelopment.inventorySytemDDD.Users.User.Domain;

import com.webDevelopment.inventorySytemDDD.Shared.Domain.Users.UserId;

import java.util.HashMap;
import java.util.Objects;

public class User {

    private UserId userId;
    private UserName userFirstName;
    private UserLastName userLastName;
    private UserNickName userNickName;
    private UserPassword userPassword;

    public User(UserId userId, UserName userFirstName, UserLastName userLastName, UserNickName userNickName, UserPassword userPassword) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userNickName = userNickName;
        this.userPassword = userPassword;
    }

    public void updateUser(UserName userFirstName, UserLastName userLastName, UserNickName userNickName)
    {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userNickName = userNickName;
    }

    public boolean equalsById(String otherId)
    {
        return this.userId.equals(new UserId(otherId));
    }

    public HashMap<String, String> data()
    {
        HashMap<String, String> data = new HashMap<String, String>() {{
            put("id", userId.value());
            put("name", userFirstName.value());
            put("lastname", userLastName.value());
            put("nickname", userNickName.value());
        }};
        return data;
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
