package com.javas.yoedu_be.controllers;

import com.javas.yoedu_be.common.ApiResponse;
import com.javas.yoedu_be.dto.auth.AuthResponse;
import com.javas.yoedu_be.dto.auth.CurrentUserResponse;
import com.javas.yoedu_be.dto.auth.LoginRequest;
import com.javas.yoedu_be.dto.auth.RegisterRequest;
import com.javas.yoedu_be.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ApiResponse.success("Login successful", authService.login(request));
    }

    @PostMapping("/register")
    public ApiResponse<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ApiResponse.success("Registration successful", authService.register(request));
    }

    @GetMapping("/me")
    public ApiResponse<CurrentUserResponse> me(Authentication authentication) {
        return ApiResponse.success(authService.me(authentication.getName()));
    }
}