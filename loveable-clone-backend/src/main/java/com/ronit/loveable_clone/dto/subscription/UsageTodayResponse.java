package com.ronit.loveable_clone.dto.subscription;

public record UsageTodayResponse(
        Long tokenUsed,
        Long tokenLimit,
        int previewRunning,
        int previewLimit
) {
}
