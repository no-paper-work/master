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
public class LanguageDTO extends AbstractAuditDTO {
	
	private static final long serialVersionUID = 5532520815179575790L;

	private UUID id;
	
	@NotNull(message = "Language Name cannot be null")
	@Size(min = 2, max = 200, message = "Language Name must be between 2 and 200 characters")
	private String name;

}
