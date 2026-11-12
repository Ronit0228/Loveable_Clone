package com.ronit.loveable_clone.sevice.implementation;

import com.ronit.loveable_clone.dto.auth.UserProfileResponse;
import com.ronit.loveable_clone.sevice.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(UUID userId) {
        return null;
    }
}
