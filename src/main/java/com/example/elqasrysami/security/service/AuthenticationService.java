package com.example.elqasrysami.security.service;

import com.example.elqasrysami.security.request.SignInRequest;
import com.example.elqasrysami.security.request.SignUpRequest;
import com.example.elqasrysami.security.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SignInRequest request);
}
