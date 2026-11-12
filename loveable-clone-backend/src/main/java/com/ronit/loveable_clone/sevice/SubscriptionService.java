package com.ronit.loveable_clone.sevice;

import com.ronit.loveable_clone.dto.subscription.CheckoutRequest;
import com.ronit.loveable_clone.dto.subscription.CheckoutResponse;
import com.ronit.loveable_clone.dto.subscription.PortalResponse;
import com.ronit.loveable_clone.dto.subscription.SubscriptionResponse;

import java.util.UUID;

public interface SubscriptionService {
    SubscriptionResponse getMyCurrentSubscription(UUID userId);
    CheckoutResponse createCheckoutSession(CheckoutRequest checkoutRequest, UUID userId);
    PortalResponse openCustomerPortal(UUID userId);
}
