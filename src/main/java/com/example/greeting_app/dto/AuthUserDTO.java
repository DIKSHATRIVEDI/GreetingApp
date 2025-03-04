package com.example.greeting_app.dto;

import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthUserDTO {

    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^[A-Z][a-z]*$", message = "First name must start with an uppercase letter")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[A-Z][a-z]*$", message = "Last name must start with an uppercase letter")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()_+{}:;,.<>?])(?=.*[0-9]).{8,}$",
            message = "Password must contain at least 1 uppercase letter, 1 special character, 1 number, and be at least 8 characters long"
    )
    private String password;
}

