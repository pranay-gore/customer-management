package com.business.customermanagement.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.entities.Customer;

@Component
public class CustomerConverter {
	
	public CustomerDto entityToDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setAddress(customer.getAddress());
		customerDto.setId(customer.getId());
		return customerDto;
	}
	
	public List<CustomerDto> entityToDto(List<Customer> customers) {
		if(customers.isEmpty()) {
			return new ArrayList<CustomerDto>();
		}
		return customers.stream().map(customer -> entityToDto(customer)).collect(Collectors.toList());
	}
	
	public Customer DtoToEntity(CustomerDto customerDto) {
		Customer Customer = new Customer();
		Customer.setFirstName(customerDto.getFirstName());
		Customer.setLastName(customerDto.getLastName());
		Customer.setAddress(customerDto.getAddress());
		return Customer;
	}
	
	public List<Customer> DtoToEntity(List<CustomerDto> customerDtos) {
		return customerDtos.stream().map(customerDto -> DtoToEntity(customerDto)).collect(Collectors.toList());
	}
}
