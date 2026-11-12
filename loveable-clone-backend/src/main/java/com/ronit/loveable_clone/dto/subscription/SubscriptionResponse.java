package com.ronit.loveable_clone.dto.subscription;

import java.time.Instant;

public record SubscriptionResponse(
        PlanResponse planResponse,
        String status,
        Instant periodEnd,
        Long tokenUsedByThisCycle
) {
}
