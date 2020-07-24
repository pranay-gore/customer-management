package com.business.customermanagement.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorConstant {

	CUSTOMER_NOT_FOUND("CUSTOMER_NOT_FOUND", "Customer with given id does not exist"),
	CUSTOMERS_NOT_FOUND("CUSTOMERS_NOT_FOUND", "Customers do not exist"),
	SERVER_ERROR("INTERNAL_SERVER_ERROR", "Something went wrong. Please try again later");

	private final String errorCode;
	private final String errorMessage;

}
