package com.nopaper.work.master.reactive.repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.nopaper.work.master.models.Currency;

import reactor.core.publisher.Flux;

public interface CurrencyReactiveRepository extends R2dbcRepository<Currency, UUID> {

	Flux<Currency> findByStatus(String defaultStatus);
}
