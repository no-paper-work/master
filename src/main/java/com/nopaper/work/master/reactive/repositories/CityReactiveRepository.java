package com.nopaper.work.master.reactive.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;

import com.nopaper.work.master.models.City;

import reactor.core.publisher.Flux;

public interface CityReactiveRepository extends R2dbcRepository<City, UUID> {

	@Query("SELECT c FROM City c WHERE c.stateId = :stateId and c.status = :status")
	Flux<City> getCityListByStateId(@Param("stateId") UUID id, @Param("status") String status);

	Flux<City> findByStatus(String defaultStatus);
}
