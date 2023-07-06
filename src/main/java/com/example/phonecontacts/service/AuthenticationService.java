package com.example.phonecontacts.service;

import com.example.phonecontacts.entity.User;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

    public ResponseEntity<?> authenticate(User user);

    public ResponseEntity<?> registrateNewUser(User user);
}
