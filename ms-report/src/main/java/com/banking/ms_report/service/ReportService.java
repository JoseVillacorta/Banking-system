package com.banking.ms_report.service;

import reactor.core.publisher.Mono;

public interface ReportService {
    Mono<byte[]> getCollectionSheetPdf(String zoneId);
}
