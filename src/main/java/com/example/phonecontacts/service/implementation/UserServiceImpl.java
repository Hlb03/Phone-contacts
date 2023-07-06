package com.example.phonecontacts.service.implementation;

import com.example.phonecontacts.entity.User;
import com.example.phonecontacts.repository.UserRepository;
import com.example.phonecontacts.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createNewUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.getUserByUserName(email);
    }

    @Override
    public void deleteUser(String mail) {
        userRepository.deleteByUserName(mail);
    }
}
