package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TicketNotFoundException extends RuntimeException {
	private static final long SerialVersionUID = 1L;
	private String resouceName;

	public TicketNotFoundException(String resouceName) {
		super(String.format("%sNot Found", resouceName));
		this.resouceName = resouceName;
	}

	public String getResouceName() {
		return resouceName;
	}

}
