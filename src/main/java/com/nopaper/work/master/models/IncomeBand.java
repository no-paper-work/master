/**
 * 
 */
package com.nopaper.work.master.models;

import java.util.UUID;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import com.nopaper.work.master.models.audit.AbstractAuditEntity;

import io.hypersistence.utils.hibernate.type.array.StringArrayType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@DynamicInsert
@DynamicUpdate
@Table(name = "income_band", schema = "npw")
public class IncomeBand extends AbstractAuditEntity {

	/*
	 * id
	 * Range
	 * paymentFrequency
	 * countryId
	 * currencyId
	 * 
	 */

	private static final long serialVersionUID = 453801599650028518L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private UUID id;

	@Column
	private UUID countryId;
	
	@Column
	private UUID currencyId;
	
	@Type(StringArrayType.class)
    @Column(
        name = "range",
        columnDefinition = "text[]"
    )
	private String[] range;
	
	@Type(StringArrayType.class)
    @Column(
        name = "payment_frequency",
        columnDefinition = "text[]"
    )
	private String[] paymentFrequency;
	
}
