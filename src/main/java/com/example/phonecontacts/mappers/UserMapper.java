package com.example.phonecontacts.mappers;

import com.example.phonecontacts.builder.UserBuilder;
import com.example.phonecontacts.dto.UserDTO;
import com.example.phonecontacts.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final UserBuilder builder;

    public UserMapper(UserBuilder builder) {
        this.builder = builder;
    }

    public User convertDTO(UserDTO dto) {
        return builder
                .builder()
                .setUsername(dto.getLogin())
                .setPassword(dto.getPassword())
                .build();
    }
}
