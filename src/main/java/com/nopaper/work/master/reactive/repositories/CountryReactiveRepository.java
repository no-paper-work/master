package com.nopaper.work.master.reactive.repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.nopaper.work.master.models.Country;

import reactor.core.publisher.Flux;

public interface CountryReactiveRepository extends R2dbcRepository<Country, UUID> {

	Flux<Country> findByStatus(String defaultStatus);
}
