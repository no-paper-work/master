package com.nopaper.work.master.reactive.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;

import com.nopaper.work.master.models.State;

import reactor.core.publisher.Flux;

public interface StateReactiveRepository extends R2dbcRepository<State, UUID>{

	@Query("SELECT s FROM State s WHERE s.countryId = :countryId and s.status = :status")
	Flux<State> getStateListByCountryId(@Param("countryId") UUID id, @Param("status") String status);

	Flux<State> findByStatus(String defaultStatus);
}
