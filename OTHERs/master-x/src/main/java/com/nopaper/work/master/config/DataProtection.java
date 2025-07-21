package com.nopaper.work.master.config;

import org.springframework.beans.factory.annotation.Autowired;

import com.nopaper.work.master.utilities.EncryptionUtil;

import jakarta.persistence.AttributeConverter;

public class DataProtection implements AttributeConverter<String, String> {
	@Autowired
	EncryptionUtil encryptionUtil;

	@Override
	public String convertToDatabaseColumn(String s) {
		return encryptionUtil.encrypt(s);
	}

	@Override
	public String convertToEntityAttribute(String s) {
		return encryptionUtil.decrypt(s);
	}
}
