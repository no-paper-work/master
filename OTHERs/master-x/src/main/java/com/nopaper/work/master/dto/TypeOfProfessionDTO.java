/**
 * 
 */
package com.nopaper.work.master.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TypeOfProfessionDTO extends AbstractAuditDTO {

	private static final long serialVersionUID = -4825590056726179162L;

	private UUID id;
	
	@NotNull(message = "Profession Name cannot be null")
	@Size(min = 2, max = 100, message = "Profession Name must be between 2 and 100 characters")
	private String name;
	
}
