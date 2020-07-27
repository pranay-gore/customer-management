package com.business.customermanagement.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import com.business.customermanagement.constants.ErrorConstant;

public class CustomerExceptionHandlerTest {
	
	@InjectMocks
	private CustomerExceptionHandler exceptionHandler;
	
	@Mock
	private CustomerNotFoundException notFoundException;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testHandleCustomerNotFoundException() {
		assertThat(exceptionHandler.handleCustomerNotFoundException(notFoundException).getStatusCode())
		.isEqualTo(HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void testHandleGlobalException() {
		assertThat(exceptionHandler.handleGlobalException(new Exception()).getStatusCode())
		.isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
