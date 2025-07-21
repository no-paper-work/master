/**
 * 
 */
package com.nopaper.work.master.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nopaper.work.master.models.Relations;

/**
 * 
 */
public interface RelationsRepository extends JpaRepository<Relations, UUID> {

}
