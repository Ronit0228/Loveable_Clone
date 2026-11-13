package com.ronit.loveable_clone.controllers;

import com.ronit.loveable_clone.dto.subscription.PlanLimitResponse;
import com.ronit.loveable_clone.dto.subscription.UsageTodayResponse;
import com.ronit.loveable_clone.sevice.UsageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/usage")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UsageController {

    UsageService usageService;

    @GetMapping("/today")
    public ResponseEntity<UsageTodayResponse> getTodayUsage() {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(usageService.getTodayUsageOfUser(userId));
    }

    @GetMapping("/limits")
    public ResponseEntity<PlanLimitResponse> getPlanLimits() {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(usageService.getCurrentSubscriptionLimitOfUser(userId));
    }
}

