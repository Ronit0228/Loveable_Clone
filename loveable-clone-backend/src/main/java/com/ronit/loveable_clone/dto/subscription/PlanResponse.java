package com.ronit.loveable_clone.dto.subscription;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.UUID;

public record PlanResponse(
        UUID id,
        String name,
        String stripePriceId,
        Integer maxProjects,
        Integer maxTokensPerDay,
        Integer maxPreview,
        Boolean unlimitedAi,
        String price

) {
}
