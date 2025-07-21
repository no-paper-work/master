package com.nopaper.work.master.reactive.repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.nopaper.work.master.models.ProductSpecification;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductSpecificationReactiveRepository extends R2dbcRepository<ProductSpecification, UUID> {
	Mono<ProductSpecification> findByName(String name);
	Mono<ProductSpecification> findById(UUID id);

	Flux<ProductSpecification> findByStatus(String defaultStatus);
}
