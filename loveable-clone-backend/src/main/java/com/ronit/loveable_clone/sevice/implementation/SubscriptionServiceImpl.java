package com.ronit.loveable_clone.sevice.implementation;

import com.ronit.loveable_clone.dto.subscription.CheckoutRequest;
import com.ronit.loveable_clone.dto.subscription.CheckoutResponse;
import com.ronit.loveable_clone.dto.subscription.PortalResponse;
import com.ronit.loveable_clone.dto.subscription.SubscriptionResponse;
import com.ronit.loveable_clone.sevice.SubscriptionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getMyCurrentSubscription(UUID userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSession(CheckoutRequest checkoutRequest, UUID userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(UUID userId) {
        return null;
    }
}
