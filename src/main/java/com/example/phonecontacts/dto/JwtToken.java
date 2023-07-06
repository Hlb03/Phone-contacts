package com.example.phonecontacts.dto;


public class JwtToken {

    public JwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    private final String jwtToken;

    public String getJwtToken() {
        return jwtToken;
    }
}
