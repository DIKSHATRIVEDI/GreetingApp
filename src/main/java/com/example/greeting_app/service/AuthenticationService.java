package com.example.greeting_app.service;

import com.example.greeting_app.dto.AuthUserDTO;
import com.example.greeting_app.model.AuthUser;
import com.example.greeting_app.repository.AuthUserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationService {

    private final AuthUserRepository authUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthenticationService(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Transactional
    public String registerUser(AuthUserDTO authUserDTO) {
        // Check if email already exists
        if (authUserRepository.existsByEmail(authUserDTO.getEmail())) {
            throw new RuntimeException("Email is already in use.");
        }

        // Hash password before saving
        String hashedPassword = passwordEncoder.encode(authUserDTO.getPassword());

        // Create and save user
        AuthUser user = new AuthUser();
        user.setFirstName(authUserDTO.getFirstName());
        user.setLastName(authUserDTO.getLastName());
        user.setEmail(authUserDTO.getEmail());
        user.setPassword(hashedPassword);
        authUserRepository.save(user);

        return "User registered successfully!";
    }
}

