package com.banking.ms_logistics.handler;

import com.banking.ms_logistics.common.response.ApiResponse;
import com.banking.ms_logistics.service.LogisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class LogisticsHandler {

    private final LogisticsService logisticsService;
    public Mono<ServerResponse> generateDailyRoute(ServerRequest request) {
        Long zoneId = Long.parseLong(request.pathVariable("zoneId"));
        return logisticsService.generateDailyRoute(zoneId)
                .collectList()
                .flatMap(route -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(ApiResponse.success(route, "Hoja de cobro diaria generada correctamente", 200)));
    }
}
