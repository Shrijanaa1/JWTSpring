package com.example.JWTspring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticateResponse {
    private final String jwt;

    public String getJwt(){
        return jwt;
    }
}
