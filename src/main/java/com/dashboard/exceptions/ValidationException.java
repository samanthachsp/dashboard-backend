package com.dashboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ValidationException extends APIException {
	public ValidationException(String message){
		super(HttpStatus.FORBIDDEN, message);
	}

}
