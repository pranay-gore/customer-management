package com.business.customermanagement.converters;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import com.business.customermanagement.constants.ErrorConstant;
import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.entities.Customer;
import com.business.customermanagement.exceptions.CustomerNotFoundException;

@Component
public class CustomerConverter {
	
	public CustomerDto entityToDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setAge(customer.getAge());
		customerDto.setAddress(customer.getAddress());
		customerDto.setId(customer.getId());
		return customerDto;
	}
	
	public List<CustomerDto> entityToDto(List<Customer> customers) {
		if(customers.isEmpty()) {
			throw new CustomerNotFoundException(ErrorConstant.CUSTOMERS_NOT_FOUND);
		}
		return customers.stream().map(customer -> entityToDto(customer)).collect(Collectors.toList());
	}
	
	public Customer dtoToEntity(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setAddress(customerDto.getAddress());
		customer.setAge(customerDto.getAge());
		return customer;
	}
	
	public List<Customer> dtoToEntity(List<CustomerDto> customerDtos) {
		return customerDtos.stream().map(customerDto -> dtoToEntity(customerDto)).collect(Collectors.toList());
	}
}
