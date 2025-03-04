package com.example.greeting_app.controller;

import com.example.greeting_app.dto.AuthUserDTO;
import com.example.greeting_app.service.AuthenticationService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //http://localhost:8080/auth/register
@RequestMapping("/auth")
public class AuthUserController {

    private final AuthenticationService authenticationService;

    public AuthUserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody AuthUserDTO authUserDTO) {
        String response = authenticationService.registerUser(authUserDTO);
        return ResponseEntity.status(201).body(response);
    }
}
