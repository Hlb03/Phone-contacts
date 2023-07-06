package com.example.phonecontacts.service.implementation;

import com.example.phonecontacts.convertion.UserConvert;
import com.example.phonecontacts.dto.JwtToken;
import com.example.phonecontacts.entity.User;
import com.example.phonecontacts.exception.RestException;
import com.example.phonecontacts.service.AuthenticationService;
import com.example.phonecontacts.service.UserService;
import com.example.phonecontacts.util.JsonTokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JsonTokenUtil tokenUtil;
    private final AuthenticationManager manager;
    private final UserDetailsService detailsService;
    private final UserService userService;
    private final UserConvert userConvert;
    private final BCryptPasswordEncoder encoder;

    public AuthenticationServiceImpl(JsonTokenUtil tokenUtil, AuthenticationManager manager, UserDetailsService detailsService, UserService userService, UserConvert userConvert, BCryptPasswordEncoder encoder) {
        this.tokenUtil = tokenUtil;
        this.manager = manager;
        this.detailsService = detailsService;
        this.userService = userService;
        this.userConvert = userConvert;
        this.encoder = encoder;
    }

    @Override
    public ResponseEntity<?> authenticate(User user) {
        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(
                    new RestException(HttpStatus.UNAUTHORIZED.value(),
                            String.format("User with login %s is trying to authenticate with bad login/password", user.getUserName())),
                    HttpStatus.UNAUTHORIZED);
        }

        UserDetails userDetails = detailsService.loadUserByUsername(user.getUserName());
        return ResponseEntity.ok(new JwtToken(tokenUtil.generateToken(userDetails)));
    }

    @Override
    public ResponseEntity<?> registrateNewUser(User user) {
        if (userService.findUserByEmail(user.getUserName()).isPresent())
            return new ResponseEntity<>(new RestException(HttpStatus.BAD_REQUEST.value(), "This login is already in use"), HttpStatus.BAD_REQUEST);

        user.setPassword(
                encoder.encode(user.getPassword())
        );
        userService.createNewUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
