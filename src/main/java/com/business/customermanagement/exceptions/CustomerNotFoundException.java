package com.business.customermanagement.exceptions;

import com.business.customermanagement.constants.ErrorConstant;

import lombok.Getter;

@Getter
public class CustomerNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String exceptionCode;
	private String exceptionMessage;

	public CustomerNotFoundException(ErrorConstant constant) {
		this.exceptionCode = constant.getErrorCode();
		this.exceptionMessage = constant.getErrorMessage();
	}

}
