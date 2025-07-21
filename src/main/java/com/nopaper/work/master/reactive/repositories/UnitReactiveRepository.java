package com.nopaper.work.master.reactive.repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.nopaper.work.master.models.Unit;

import reactor.core.publisher.Flux;

public interface UnitReactiveRepository extends R2dbcRepository<Unit, UUID> {

	Flux<Unit> findByStatus(String defaultStatus);
}
