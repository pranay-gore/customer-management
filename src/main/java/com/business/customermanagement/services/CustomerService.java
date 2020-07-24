package com.business.customermanagement.services;

import java.util.List;
import java.util.Optional;

import com.business.customermanagement.dtos.CustomerDto;

public interface CustomerService {
	
	CustomerDto addCustomer(CustomerDto customerDto);

	CustomerDto updateCustomer(Integer id, CustomerDto customerDto);

	List<CustomerDto> getAllCustomers();

	CustomerDto getCustomerById(Integer id);

	List<CustomerDto> getByCustomerName(Optional<String> firstName, Optional<String> lastName);

}