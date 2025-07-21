/**
 * 
 */
package com.nopaper.work.master.dto;

import java.util.UUID;

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
public class IncomeBandDTO extends AbstractAuditDTO {

	private static final long serialVersionUID = 332279155956298297L;

	private UUID id;

	private UUID countryId;
	
	private UUID currencyId;
	
	private String[] range;
	
	private String[] paymentFrequency;
	
}
