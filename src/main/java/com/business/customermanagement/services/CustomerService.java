package com.business.customermanagement.services;

import java.util.List;
import com.business.customermanagement.dtos.CustomerDto;

public interface CustomerService {
	
	CustomerDto addCustomer(CustomerDto customerDto);

	CustomerDto updateCustomer(Integer id, CustomerDto customerDto);

	List<CustomerDto> getAllCustomers();

	CustomerDto getCustomerById(Integer id);

}