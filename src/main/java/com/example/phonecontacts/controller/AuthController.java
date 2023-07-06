package com.example.phonecontacts.controller;

import com.example.phonecontacts.convertion.UserConvert;
import com.example.phonecontacts.dto.UserDTO;
import com.example.phonecontacts.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final UserConvert userConvert;
    private final AuthenticationService authenticationService;

    public AuthController(UserConvert userConvert, AuthenticationService authenticationService) {
        this.userConvert = userConvert;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDTO userData) {
        return authenticationService.authenticate(
                userConvert.convertDTO(userData)
        );
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registrateUser(@RequestBody UserDTO userDTO) {
        return authenticationService.registrateNewUser(
                userConvert.convertDTO(userDTO)
        );
    }
}
