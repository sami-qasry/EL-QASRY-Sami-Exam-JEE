package com.example.elqasrysami.security.controller;

import com.example.elqasrysami.security.request.SignInRequest;
import com.example.elqasrysami.security.request.SignUpRequest;
import com.example.elqasrysami.security.service.AuthenticationService;
import com.example.elqasrysami.security.service.JwtService;
import com.example.elqasrysami.security.service.UserService;
import com.example.elqasrysami.utils.ResponseHandler;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final JwtService jwtService;
    Logger logger = LogManager.getLogger(AuthenticationController.class);

    @PostMapping("/signup")
    public ResponseEntity<Object> register(@RequestBody SignUpRequest request) {
        logger.info("New user registered with email: {}", request.getEmail());
        return ResponseHandler.generateResponse(
                "registering a new user",
                HttpStatus.OK,
                authenticationService.signup(request)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody SignInRequest request) {
        logger.info("user with email:  {} trying to login.", request.getEmail());

        return ResponseHandler.generateResponse(
                "login successfully",
                HttpStatus.OK,
                authenticationService.signin(request)
        );
    }

    @GetMapping("/me")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Object> getProfile(@NonNull HttpServletRequest request) {
        String username = jwtService.extractUsername(request.getHeader("Authorization").substring(7));
        logger.info("user with email {} requested token validation", username);
        return ResponseHandler.generateResponse(
                "Token is valid and user is logged in.",
                HttpStatus.OK,
                userService.loadUserByUsername(username)
        );
    }
}
