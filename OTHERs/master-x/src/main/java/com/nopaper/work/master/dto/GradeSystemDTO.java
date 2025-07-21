/**
 * 
 */
package com.nopaper.work.master.dto;

import java.util.Map;
import java.util.UUID;

import com.nopaper.work.master.enums.EScoringSystem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GradeSystemDTO extends AbstractAuditDTO {
	
	private static final long serialVersionUID = 2276444113128328200L;
	private UUID id;
	private EScoringSystem scoringSystem;
	private Integer maxScore;
	private Integer minScore;
	private Map<String, String> value;
	private Integer maxScoreWeightage;
	private Integer minScoreWeightage;

}
