package com.example.phonecontacts.builder;

import com.example.phonecontacts.entity.User;

public interface UserBuilder {

    UserBuilder setUsername(String userName);
    UserBuilder setPassword(String password);
    User build();
}
