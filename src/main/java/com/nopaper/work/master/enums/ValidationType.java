/**
 * git Config: 
 * Project Name: master
 * Created: 2 Aug 2023 23:55:31
 * Author: metis
 * Copyright # Saikat Barman
 * 
 */
package com.nopaper.work.master.enums;

/**
 * 
 */
public enum ValidationType {

	ANONYMOUS("Online");

	String value;

	ValidationType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
