package com.banking.ms_report.handler;

import com.banking.ms_report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ReportHandler {
    private final ReportService reportService;

    public Mono<ServerResponse> getCollectionSheetPdf(ServerRequest request){
        String zoneId = request.pathVariable("zoneId");

        return reportService.getCollectionSheetPdf(zoneId)
                .flatMap(pdfBytes -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_PDF)
                        .header("Content-Disposition", "attachment; filename=hoja-cobro-zona-" + zoneId + ".pdf")
                        .bodyValue(pdfBytes));
    }
}
