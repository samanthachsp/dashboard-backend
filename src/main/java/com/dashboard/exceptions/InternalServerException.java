package com.dashboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InternalServerException extends APIException {
	public InternalServerException(String message){
		super(HttpStatus.INTERNAL_SERVER_ERROR, message);
	}
}
