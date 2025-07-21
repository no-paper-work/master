/**
 * 
 */
package com.nopaper.work.master.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nopaper.work.master.models.GradeSystem;

/**
 * 
 */
public interface GradeSystemRepository extends JpaRepository<GradeSystem, UUID> {

}