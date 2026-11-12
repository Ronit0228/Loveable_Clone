package com.ronit.loveable_clone.sevice;

import com.ronit.loveable_clone.dto.auth.UserProfileResponse;

import java.util.UUID;

public interface UserService {
    UserProfileResponse getProfile(UUID userId);
}
