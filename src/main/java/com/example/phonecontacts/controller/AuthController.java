package com.example.phonecontacts.controller;

import com.example.phonecontacts.mappers.UserMapper;
import com.example.phonecontacts.dto.UserDTO;
import com.example.phonecontacts.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final UserMapper userMapper;
    private final AuthenticationService authenticationService;

    public AuthController(UserMapper userConvert, AuthenticationService authenticationService) {
        this.userMapper = userConvert;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDTO userData) {
        return authenticationService.authenticate(
                userMapper.convertDTO(userData)
        );
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registrateUser(@RequestBody UserDTO userDTO) {
        return authenticationService.registrateNewUser(
                userMapper.convertDTO(userDTO)
        );
    }
}
