package com.ronit.loveable_clone.dto.auth;

import java.util.UUID;

public record UserProfileResponse(
        UUID id,
        String name,
        String email,
        String avatar
) {
}
