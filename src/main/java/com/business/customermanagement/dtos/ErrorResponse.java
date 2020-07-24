package com.business.customermanagement.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
	
	  private LocalDateTime timestamp;
	  private String errorCode;
	  private String errorMessage;

}
