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
public class TypeOfServiceDTO extends AbstractAuditDTO {
	
	private static final long serialVersionUID = 6595177398799339829L;

	private UUID id;

	@NotNull(message = "Service Name cannot be null")
	@Size(min = 2, max = 100, message = "Service Name must be between 2 and 100 characters")
	private String name;

}
