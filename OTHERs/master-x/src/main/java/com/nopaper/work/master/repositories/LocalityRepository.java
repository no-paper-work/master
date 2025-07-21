/**
 * 
 */
package com.nopaper.work.master.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nopaper.work.master.models.Locality;

/**
 * 
 */
public interface LocalityRepository extends JpaRepository<Locality, UUID> {
	
	@Query("SELECT c FROM Locality c WHERE c.cityId = :cityId and c.status = :status")
	List<Locality> getLocalityListByCityId(@Param("cityId") UUID id, @Param("status") String status);
	
	List<Locality> findByStatus(String defaultStatus);
	
}
