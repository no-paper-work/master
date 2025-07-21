package com.nopaper.work.master.reactive.repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.nopaper.work.master.models.Category;

import reactor.core.publisher.Flux;

public interface CategoryReactiveRepository extends R2dbcRepository<Category, UUID> {

	Flux<Category> findByStatus(String defaultStatus);
}
