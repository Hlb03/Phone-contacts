package com.example.phonecontacts.service;

import com.example.phonecontacts.entity.User;

import java.util.Optional;

public interface UserService {

    public void createNewUser(User user);

    public Optional<User> findUserByEmail(String email);

    public void deleteUser(String mail);
}
