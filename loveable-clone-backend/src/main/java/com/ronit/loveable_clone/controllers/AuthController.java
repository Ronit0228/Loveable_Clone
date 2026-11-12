package com.ronit.loveable_clone.controllers;

import com.ronit.loveable_clone.dto.auth.AuthResponse;
import com.ronit.loveable_clone.dto.auth.LoginRequest;
import com.ronit.loveable_clone.dto.auth.SignupRequest;
import com.ronit.loveable_clone.dto.auth.UserProfileResponse;
import com.ronit.loveable_clone.sevice.AuthService;
import com.ronit.loveable_clone.sevice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(SignupRequest signupRequest) {
        return ResponseEntity.ok(authService.signup(signupRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(LoginRequest loginRequest) {
        // TODO:
        return ResponseEntity.ok((authService.login(loginRequest)));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(userService.getProfile(userId));
    }
}
