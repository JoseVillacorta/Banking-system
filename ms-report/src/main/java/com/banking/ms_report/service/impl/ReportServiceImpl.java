package com.banking.ms_report.service.impl;

import com.banking.ms_report.generator.PdfGenerator;
import com.banking.ms_report.service.ReportService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    private final WebClient webClient;
    private final PdfGenerator pdfGenerator;

    public ReportServiceImpl(WebClient.Builder webClientBuilder, PdfGenerator pdfGenerator){
        this.webClient = webClientBuilder.build();
        this.pdfGenerator = pdfGenerator;
    }

    @Override
    public Mono<byte[]> getCollectionSheetPdf(String zoneId){
        return webClient.get()
                .uri("http://ms-logistics/api/v1/logistics/routes/" + zoneId)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    // Extraemos la lista que viene en "data" desde ms-logistics
                    List<Map<String, Object>> data = (List<Map<String, Object>>) response.get("data");
                    return pdfGenerator.generateCollectionSheet(data, zoneId);
                });
    }
}
