package com.example.phonecontacts.builder;

import com.example.phonecontacts.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserBuilder {

    private User user;

    public UserBuilder() {}


    public UserBuilder builder() {
        user = new User();
        return this;
    }

    public UserBuilder setUsername(String userName) {
        user.setUserName(userName);
        return this;
    }

    public UserBuilder setPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public User build() {
        return user;
    }
}
