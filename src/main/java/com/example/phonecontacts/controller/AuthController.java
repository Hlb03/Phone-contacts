package com.example.phonecontacts.controller;

import com.example.phonecontacts.mappers.UserMapper;
import com.example.phonecontacts.dto.UserDTO;
import com.example.phonecontacts.service.AuthenticationService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "AuthController", description = "Controller for user authentication and registration user")
//@Api("This controller is responsible for user authentication and registration")
public class AuthController {
    private final UserMapper userMapper;
    private final AuthenticationService authenticationService;

    public AuthController(UserMapper userConvert, AuthenticationService authenticationService) {
        this.userMapper = userConvert;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/auth")
    @Operation(description = "Authenticates user by his credentials. In case of success return token (active for 30 minutes)")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDTO userData) {
        return authenticationService.authenticate(
                userMapper.convertDTO(userData)
        );
    }

    @PostMapping("/registration")
    @Operation(description = "Adds new user in case of unique login. Otherwise - 400 status code")
    public ResponseEntity<?> userRegistration(@RequestBody UserDTO userDTO) {
        return authenticationService.registrateNewUser(
                userMapper.convertDTO(userDTO)
        );
    }
}
