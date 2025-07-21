/**
 * 
 */
package com.nopaper.work.master.dto;

/**
 * 
 */

import java.util.UUID;

import com.nopaper.work.master.enums.ERelations;

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
public class RelationsDTO extends AbstractAuditDTO {

	private static final long serialVersionUID = -3617153123917021067L;
	
	private UUID id;
	private ERelations name;
	private String description;
	private Boolean isImmediate;
}