package com.banking.ms_logistics.service.impl;

import com.banking.ms_logistics.dto.response.RouteResponse;
import com.banking.ms_logistics.service.LogisticsService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class LogisticsServiceImpl implements LogisticsService {

    private final WebClient webClient;

    public LogisticsServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Override
    public Flux<RouteResponse> generateDailyRoute(Long zoneId) {
        // 1. Llamamos a ms-customer para obtener los clientes de la zona
        return webClient.get()
                .uri("http://ms-customer/api/v1/customers/zone/" + zoneId)
                .retrieve()
                .bodyToMono(Map.class)
                .flatMapMany(response -> {
                    // Sacamos la lista que viene dentro de "data"
                    List<Map<String, Object>> customers = (List<Map<String, Object>>) response.get("data");
                    return Flux.fromIterable(customers);
                })
                .flatMap(customer -> {
                    // Sacamos los datos del cliente de forma segura
                    String customerId = customer.get("id").toString();
                    String name = customer.get("firstName") + " " + customer.get("lastName");
                    String address = customer.get("address") != null ? customer.get("address").toString()
                            : "Dirección no registrada";
                    return webClient.get()
                            .uri("http://ms-loan/api/v1/loans/customer/" + customerId)
                            .retrieve()
                            .bodyToMono(Map.class)
                            .flatMapMany(loanResponse -> {
                                List<Map<String, Object>> loans = (List<Map<String, Object>>) loanResponse.get("data");
                                return Flux.fromIterable(loans);
                            })
                            .collectList()
                            .map(loans -> {
                                // Calculamos el monto total
                                BigDecimal total = loans.stream()
                                        .map(l -> {
                                            // Intentamos leer totalToPay o total_to_pay por si acaso
                                            Object value = l.get("totalToPay") != null ? l.get("totalToPay")
                                                    : l.get("total_to_pay");
                                            return value != null ? new BigDecimal(value.toString()) : BigDecimal.ZERO;
                                        })
                                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                                // Sumamos la cantidad de cuotas que tiene cada préstamo
                                Integer totalInstallments = loans.stream()
                                        .map(l -> (Integer) l.get("installmentsCount"))
                                        .reduce(0, Integer::sum);

                                return RouteResponse.builder()
                                        .customerName(name)
                                        .address(address)
                                        .pendingAmount(total)
                                        .pendingInstallments(totalInstallments)
                                        .build();
                            });
                });
    }
}
