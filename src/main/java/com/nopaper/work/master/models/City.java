package com.nopaper.work.master.models;

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
@Table(name = "city", schema = "npw")
public class City extends AbstractAuditEntity {
	/**
	 *
	 */
	private static final long serialVersionUID = -4041073308953210321L;

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private UUID id;

	@Column(length = 200, nullable = false, unique = true)
	private String name;

	@Column(length = 50, nullable = false, unique = true)
	private String code;

	@Column(length = 50, nullable = false)
	private String telephoneCode;

	@Column(length = 10, nullable = true)
	private String pin;

	@Column
	private UUID stateId;

}
