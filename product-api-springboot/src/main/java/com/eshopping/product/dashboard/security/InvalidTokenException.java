package com.eshopping.product.dashboard.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid token")
public class InvalidTokenException extends RuntimeException {
	public InvalidTokenException() {

	}

	public InvalidTokenException(String message) {
		super(message);
	}
}
