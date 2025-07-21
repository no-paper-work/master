package com.nopaper.work.master.reactive.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;

import com.nopaper.work.master.models.Product;

import reactor.core.publisher.Flux;

public interface ProductReactiveRepository extends R2dbcRepository<Product, UUID> {

	@Query("SELECT p FROM Product p WHERE p.subCategoryId = :subCategoryId and p.status = :status")
	Flux<Product> getProductBySubCategoryId(@Param("subCategoryId") UUID id, @Param("status") String status);

	Flux<Product> findByStatus(String defaultStatus);
}
