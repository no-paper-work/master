package com.nopaper.work.master.reactive.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;

import com.nopaper.work.master.models.SubCategory;

import reactor.core.publisher.Flux;

public interface SubCategoryReactiveRepository extends R2dbcRepository<SubCategory, UUID>{

	@Query("SELECT s FROM SubCategory s WHERE s.categoryId = :categoryId and s.status = :status")
	Flux<SubCategory> getSubCategoryByCategoryId(@Param("categoryId") UUID id, @Param("status") String status);

	Flux<SubCategory> findByStatus(String defaultStatus);
}
