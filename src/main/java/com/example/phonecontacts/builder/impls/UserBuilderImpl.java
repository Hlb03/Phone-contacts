package com.example.phonecontacts.builder.impls;

import com.example.phonecontacts.builder.UserBuilder;
import com.example.phonecontacts.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserBuilderImpl implements UserBuilder {

    private final User user;

    public UserBuilderImpl() {
        this.user = new User();
    }

    @Override
    public UserBuilder setUsername(String userName) {
        user.setUserName(userName);
        return this;
    }

    @Override
    public UserBuilder setPassword(String password) {
        user.setPassword(password);
        return this;
    }

    @Override
    public User build() {
        return user;
    }
}
