package com.business.customermanagement.dtos;

import lombok.Data;

/**
 * Represents a customer dto.
 */
@Data
public class CustomerDto {

	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String address;
}
