package com.ronit.loveable_clone.dto.subscription;

public record PlanLimitResponse(
    String planName,
    Long maxTokenPerDay,
    Long maxProject,
    boolean unlimitedAi
) {
}
