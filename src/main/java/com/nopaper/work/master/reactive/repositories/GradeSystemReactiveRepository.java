/**
 * 
 */
package com.nopaper.work.master.reactive.repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.nopaper.work.master.models.GradeSystem;

import reactor.core.publisher.Flux;

/**
 * 
 */
public interface GradeSystemReactiveRepository extends R2dbcRepository<GradeSystem, UUID> {

	/**
	 * @param defaultStatus
	 * @return
	 */
	Flux<GradeSystem> findByStatus(String defaultStatus);

}