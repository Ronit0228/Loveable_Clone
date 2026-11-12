package com.ronit.loveable_clone.dto.project;

import java.time.Instant;
import java.util.UUID;

public record ProjectSummaryResponse(
        UUID id,
        String name,
        Instant createdAt,
        Instant updatedAt
) {
}
