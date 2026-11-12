package com.ronit.loveable_clone.sevice;

import com.ronit.loveable_clone.dto.auth.AuthResponse;
import com.ronit.loveable_clone.dto.auth.LoginRequest;
import com.ronit.loveable_clone.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest signupRequest);
    AuthResponse login(LoginRequest loginRequest);
}
