/**
 * 
 */
package com.nopaper.work.master.reactive.repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.nopaper.work.master.models.Relations;

/**
 * 
 */
public interface RelationsReactiveRepository extends R2dbcRepository<Relations, UUID> {

}
