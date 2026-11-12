package com.ronit.loveable_clone.sevice.implementation;

import com.ronit.loveable_clone.dto.subscription.PlanResponse;
import com.ronit.loveable_clone.sevice.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
