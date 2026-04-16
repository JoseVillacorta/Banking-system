package com.banking.ms_logistics.service;

import com.banking.ms_logistics.dto.response.RouteResponse;
import reactor.core.publisher.Flux;

public interface LogisticsService {
    Flux<RouteResponse> generateDailyRoute(Long zoneId);
}
