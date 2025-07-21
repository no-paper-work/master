/**
 * git Config: 
 * Project Name: profile
 * Created: 1 Aug 2023 00:05:52
 * Author: metis
 * Copyright # Saikat Barman
 * 
 */
package com.nopaper.work.master.enums;

import lombok.Getter;

@Getter
public enum I18Constants {
	NO_ITEM_FOUND("item.absent");

	String key;

	I18Constants(String key) {
		this.key = key;
	}
}
