package com.banking.ms_logistics.repository;

import com.banking.ms_logistics.entities.Collector;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CollectorRepository extends ReactiveCrudRepository<Collector, Long> {
    Mono<Collector> findByDocumentNumber(String documentNumber);
}
