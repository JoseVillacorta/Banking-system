package com.banking.ms_logistics.dto.response;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class RouteResponse {
    private String customerName;
    private String address;
    private BigDecimal pendingAmount;
    private Integer pendingInstallments;
}
