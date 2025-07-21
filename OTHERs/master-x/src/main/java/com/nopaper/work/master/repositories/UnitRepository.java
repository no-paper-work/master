package com.nopaper.work.master.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nopaper.work.master.models.Unit;

public interface UnitRepository extends JpaRepository<Unit, UUID> {

	List<Unit> findByStatus(String defaultStatus);
}
