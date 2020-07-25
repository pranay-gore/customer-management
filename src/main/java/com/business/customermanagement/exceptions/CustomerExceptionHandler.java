package com.business.customermanagement.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.business.customermanagement.constants.ErrorConstant;
import com.business.customermanagement.dtos.ErrorResponse;

/**
 * The Class CustomerExceptionHandler - handles all exceptions from the applications
 */
@ControllerAdvice
public class CustomerExceptionHandler {
	
	/**
	 * Handles CustomerNotFoundException.
	 *
	 * @param notFoundException - exception of type CustomerNotFoundException
	 * @return the response entity with error code and message
	 */
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomerNotFoundException
		(CustomerNotFoundException notFoundException) {
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now() ,notFoundException.getExceptionCode(), notFoundException.getExceptionMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Handles global exception.
	 *
	 * @param exception the exception
	 * @return the response entity with error code and message
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGlobalException
		(Exception exception) {
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ErrorConstant.SERVER_ERROR.getErrorCode(), ErrorConstant.SERVER_ERROR.getErrorMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
