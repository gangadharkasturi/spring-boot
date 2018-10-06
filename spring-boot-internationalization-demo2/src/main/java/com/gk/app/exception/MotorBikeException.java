package com.gk.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MotorBikeException extends RuntimeException {

	public MotorBikeException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}

