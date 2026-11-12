package com.ronit.loveable_clone.sevice.implementation;

import com.ronit.loveable_clone.dto.auth.AuthResponse;
import com.ronit.loveable_clone.dto.auth.LoginRequest;
import com.ronit.loveable_clone.dto.auth.SignupRequest;
import com.ronit.loveable_clone.sevice.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponse signup(SignupRequest signupRequest) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        return null;
    }
}
