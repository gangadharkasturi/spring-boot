package com.gk.app.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class MotorBikeProjectExceptions extends ResponseEntityExceptionHandler {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(Exception.class)//this method handles all the exceptions
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ExpResponse expResponse = new ExpResponse(new Date(), "Something Went Wrong",ex.getMessage(), request.getContextPath());
		return new ResponseEntity(expResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(MotorBikeNotFoundException.class)//If the motorbike with the id is not found, then this will handle that exception
	public final ResponseEntity<Object> mtrBikeNtFoundExceptions(MotorBikeNotFoundException ex, WebRequest request) throws Exception {
		ExpResponse expResponse = new ExpResponse(new Date(), "MotorBike Not FOUND",ex.getMessage(), request.getContextPath());
		return new ResponseEntity(expResponse,HttpStatus.NOT_FOUND);
		
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExpResponse expResponse = new ExpResponse(new Date(), "Validations are done at backnd",ex.getMessage(), request.getContextPath());
		return new ResponseEntity(expResponse,HttpStatus.BAD_REQUEST);
	}
	
}
