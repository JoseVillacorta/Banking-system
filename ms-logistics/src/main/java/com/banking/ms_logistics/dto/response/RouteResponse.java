package com.banking.ms_logistics.dto.response;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class RouteResponse {
    private String customerName;
    private String address;
    private BigDecimal pendingAmount;
    private Integer pendingInstallments;
}
