package com.ronit.loveable_clone.dto.subscription;

import java.util.UUID;

public record CheckoutRequest(
        UUID planId
) {
}
