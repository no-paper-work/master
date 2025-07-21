/**
 * 
 */
package com.nopaper.work.master.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nopaper.work.master.models.GradeSystem;

/**
 * 
 */
public interface GradeSystemRepository extends JpaRepository<GradeSystem, UUID> {

	/**
	 * @param defaultStatus
	 * @return
	 */
	List<GradeSystem> findByStatus(String defaultStatus);

}