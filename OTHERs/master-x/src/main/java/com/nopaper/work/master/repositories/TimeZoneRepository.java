package com.nopaper.work.master.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nopaper.work.master.models.TimeZone;

public interface TimeZoneRepository extends JpaRepository<TimeZone, UUID> {
	Optional<TimeZone> findByName(String name);
	Optional<TimeZone> findById(UUID id);

	List<TimeZone> findByStatus(String defaultStatus);
}
