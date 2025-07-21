package com.nopaper.work.master.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchElementFoundException extends ResponseStatusException {

	private static final long serialVersionUID = -9029428766474316151L;

	public NoSuchElementFoundException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}

	@Override
	public HttpHeaders getResponseHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set(getDetailMessageCode(), getLocalizedMessage());
		return responseHeaders;
	}

}

/*
 * public class NoSuchElementFoundException extends RuntimeException {
 * 
 * public NoSuchElementFoundException(String message) { super(message); }
 * 
 * }
 */
