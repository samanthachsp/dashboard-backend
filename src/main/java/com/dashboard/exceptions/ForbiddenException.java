package com.dashboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ForbiddenException extends APIException {
	public ForbiddenException(String message){
		super(HttpStatus.FORBIDDEN, message);
	}

}
