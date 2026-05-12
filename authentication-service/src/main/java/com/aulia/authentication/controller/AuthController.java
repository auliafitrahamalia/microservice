package com.aulia.authentication.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulia.authentication.login.LoginRequest;
import com.aulia.authentication.login.LoginResponse;
import com.aulia.authentication.register.RegisterRequest;
import com.aulia.authentication.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request){
        return authenticationService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        return authenticationService.login(
            request.getUsername(),request.getPassword());
    }
}
