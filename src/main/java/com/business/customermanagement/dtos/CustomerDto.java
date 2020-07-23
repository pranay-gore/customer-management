package com.business.customermanagement.dtos;

import lombok.Data;

@Data
public class CustomerDto {

	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
}
