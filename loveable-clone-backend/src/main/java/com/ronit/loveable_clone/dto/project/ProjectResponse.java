package com.ronit.loveable_clone.dto.project;

import com.ronit.loveable_clone.dto.auth.UserProfileResponse;

import java.time.Instant;
import java.util.UUID;

public record ProjectResponse(
        UUID id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner
) {
}
