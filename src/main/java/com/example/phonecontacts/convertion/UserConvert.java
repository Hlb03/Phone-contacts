package com.example.phonecontacts.convertion;

import com.example.phonecontacts.builder.UserBuilder;
import com.example.phonecontacts.dto.UserDTO;
import com.example.phonecontacts.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConvert {

    private final UserBuilder builder;

    public UserConvert(UserBuilder builder) {
        this.builder = builder;
    }

    public User convertDTO(UserDTO dto) {
        return builder
                .setUsername(dto.getUsername())
                .setPassword(dto.getPassword())
                .build();
    }
}
