package com.business.customermanagement.dtos;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private String errorCode;
	private String errorMessage;

}
