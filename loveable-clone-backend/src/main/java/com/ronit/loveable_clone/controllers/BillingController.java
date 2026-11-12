package com.ronit.loveable_clone.controllers;

import com.ronit.loveable_clone.dto.subscription.*;
import com.ronit.loveable_clone.sevice.PlanService;
import com.ronit.loveable_clone.sevice.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BillingController {

    private final PlanService planService;
    private final SubscriptionService subscriptionService;

    @GetMapping("/plans")
    public ResponseEntity<List<PlanResponse>> getAllActivePlans() {
        return ResponseEntity.ok(planService.getAllActivePlans());
    }

    @GetMapping("/api/me/subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription() {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(subscriptionService.getMyCurrentSubscription(userId));
    }

    @PostMapping("/api/stripe/checkout")
    public ResponseEntity<CheckoutResponse> createCheckoutResponse(@RequestBody CheckoutRequest checkoutRequest) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(subscriptionService.createCheckoutSession(checkoutRequest, userId));
    }

    @PostMapping("/api/stripe/portal")
    public ResponseEntity<PortalResponse> openCustomerPortal() {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(subscriptionService.openCustomerPortal(userId));
    }
}
