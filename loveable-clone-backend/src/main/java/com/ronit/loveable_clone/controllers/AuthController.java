package com.ronit.loveable_clone.controllers;

import com.ronit.loveable_clone.dto.auth.AuthResponse;
import com.ronit.loveable_clone.dto.auth.LoginRequest;
import com.ronit.loveable_clone.dto.auth.SignupRequest;
import com.ronit.loveable_clone.dto.auth.UserProfileResponse;
import com.ronit.loveable_clone.sevice.AuthService;
import com.ronit.loveable_clone.sevice.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {

    AuthService authService;
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok(authService.signup(signupRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        // TODO:
        return ResponseEntity.ok((authService.login(loginRequest)));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(userService.getProfile(userId));
    }
}
