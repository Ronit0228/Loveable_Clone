package com.ronit.loveable_clone.sevice;

import com.ronit.loveable_clone.dto.subscription.PlanLimitResponse;
import com.ronit.loveable_clone.dto.subscription.UsageTodayResponse;

import java.util.UUID;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(UUID userId);
    PlanLimitResponse getCurrentSubscriptionLimitOfUser(UUID userId);
}
