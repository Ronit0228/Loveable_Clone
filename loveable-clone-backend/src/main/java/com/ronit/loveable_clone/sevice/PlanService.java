package com.ronit.loveable_clone.sevice;

import com.ronit.loveable_clone.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
