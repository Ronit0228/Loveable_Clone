package com.ronit.loveable_clone.sevice.implementation;

import com.ronit.loveable_clone.dto.subscription.PlanLimitResponse;
import com.ronit.loveable_clone.dto.subscription.UsageTodayResponse;
import com.ronit.loveable_clone.sevice.UsageService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(UUID userId) {
        return null;
    }

    @Override
    public PlanLimitResponse getCurrentSubscriptionLimitOfUser(UUID userId) {
        return null;
    }
}
