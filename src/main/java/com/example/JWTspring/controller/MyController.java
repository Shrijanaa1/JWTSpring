package com.example.JWTspring.controller;

import com.example.JWTspring.entity.AuthenticateRequest;
import com.example.JWTspring.entity.AuthenticateResponse;
import com.example.JWTspring.service.MyUserDetailService;
import com.example.JWTspring.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @GetMapping("/")
    public String home(){
        return "hello";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticateRequest authenticateRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword())
            );
        }catch (Exception e){
            throw new Exception("Invalid Username/Password");
        }
        final UserDetails userDetails = myUserDetailService
                .loadUserByUsername(authenticateRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticateResponse(jwt));
    }

}

//    public String generateToken(@RequestBody AuthenticateRequest authenticateRequest) throws  Exception{
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword())
//            );
//        }catch (Exception e){
//            throw new Exception("Invalid Username/Password");
//        }
//
//        return jwtUtil.generateToken(authenticateRequest.getUsername());
//    }