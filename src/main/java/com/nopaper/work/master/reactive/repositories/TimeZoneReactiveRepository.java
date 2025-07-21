package com.nopaper.work.master.reactive.repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.nopaper.work.master.models.TimeZone;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TimeZoneReactiveRepository extends R2dbcRepository<TimeZone, UUID> {
	Mono<TimeZone> findByName(String name);
	Mono<TimeZone> findById(UUID id);

	Flux<TimeZone> findByStatus(String defaultStatus);
}
