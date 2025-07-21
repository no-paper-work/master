package com.nopaper.work.master.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nopaper.work.master.models.ProductSpecification;

public interface ProductSpecificationRepository extends JpaRepository<ProductSpecification, UUID> {
	Optional<ProductSpecification> findByName(String name);
	Optional<ProductSpecification> findById(UUID id);

	List<ProductSpecification> findByStatus(String defaultStatus);
}
