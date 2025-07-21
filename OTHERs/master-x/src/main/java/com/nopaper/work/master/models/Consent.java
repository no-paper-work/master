package com.nopaper.work.master.models;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.nopaper.work.master.models.audit.AbstractAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "consent", schema = "npw")
public class Consent extends AbstractAuditEntity {
	private static final long serialVersionUID = -259581286241572058L;

	/**
	 *
	 */

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private UUID id;

	@Column(name = "consent_short", length = 200, nullable = false, unique = false)
	private String consent;

	@Column(name = "consent_description", length = 5000, nullable = true, unique = false)
	private String consentDescription;

	@Column(name = "consent_module", length = 50, nullable = false)
	private String consentModule;

	@Column(name = "consent_version", length = 10, nullable = true)
	private String consentVersion;
	
	@Column(name = "consent_effective_date", nullable = false, updatable = false)
	private Instant consenteffectiveDate = Instant.now();
	
}