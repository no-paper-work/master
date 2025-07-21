/**
 * 
 */
package com.nopaper.work.master.models;

import java.util.UUID;

import com.nopaper.work.master.enums.ERelations;
import com.nopaper.work.master.models.audit.AbstractAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "relations", schema = "npw", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })

public class Relations extends AbstractAuditEntity {
	
	private static final long serialVersionUID = 2062528538114112064L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private UUID id;

	@Enumerated(EnumType.STRING)
	@Column(name = "name", columnDefinition = "varchar(50)", nullable = false)
	private ERelations name;
	
	@Column(name = "description", columnDefinition = "varchar(200)", nullable = false)
	private String description;
	
	@Column(name = "isImmediate", columnDefinition = "boolean default true", nullable = false)
	private Boolean isImmediate;
	
}
