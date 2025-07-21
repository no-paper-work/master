/**
 * 
 */
package com.nopaper.work.master.reactive.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;

import com.nopaper.work.master.models.Locality;

import reactor.core.publisher.Flux;

/**
 * 
 */
public interface LocalityReactiveRepository extends R2dbcRepository<Locality, UUID> {
	
	@Query("SELECT c FROM Locality c WHERE c.cityId = :cityId and c.status = :status")
	Flux<Locality> getLocalityListByCityId(@Param("cityId") UUID id, @Param("status") String status);
	
	Flux<Locality> findByStatus(String defaultStatus);
	
}
