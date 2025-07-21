/**
 * 
 */
package com.nopaper.work.master.models;

import java.util.Map;
import java.util.UUID;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import com.nopaper.work.master.enums.EScoringSystem;
import com.nopaper.work.master.models.audit.AbstractAuditEntity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "grade_system", schema = "npw")
public class GradeSystem  extends AbstractAuditEntity {
	
	private static final long serialVersionUID = -121533021926373027L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private UUID id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "scoringSystem", columnDefinition = "varchar(50)", nullable = false)
	private EScoringSystem scoringSystem;
	
	@Column(name = "maxScore", columnDefinition = "integer", nullable = false)
	private Integer maxScore;
	
	@Column(name = "minScore", columnDefinition = "integer", nullable = false)
	private Integer minScore;
	
	@Type(JsonType.class)
	@Column(name = "value", columnDefinition = "jsonb", nullable = false)
	private Map<String, String> value;
	
	@Column(name = "maxScoreWeightage", columnDefinition = "integer", nullable = false)
	private Integer maxScoreWeightage;
	
	@Column(name = "minScoreWeightage", columnDefinition = "integer", nullable = false)
	private Integer minScoreWeightage;

}
