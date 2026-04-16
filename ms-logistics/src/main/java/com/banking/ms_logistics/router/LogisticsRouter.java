package com.banking.ms_logistics.router;

import com.banking.ms_logistics.handler.LogisticsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class LogisticsRouter {
    @Bean
    public RouterFunction<ServerResponse> logisticsRoutes(LogisticsHandler handler) {
        return route(GET("/api/v1/logistics/routes/{zoneId}"), handler::generateDailyRoute);
    }
}
