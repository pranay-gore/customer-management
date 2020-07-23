package com.business.customermanagement.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.customermanagement.converters.CustomerConverter;
import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.entities.Customer;
import com.business.customermanagement.repositories.CustomerRepository;
import com.business.customermanagement.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo; 
	
	@Autowired
	private CustomerConverter customerConverter;

	@Override
	public CustomerDto addCustomer(CustomerDto customerDto) {
		Customer customer = customerConverter.DtoToEntity(customerDto);
		return customerConverter.entityToDto(customerRepo.save(customer));
	}

	@Override
	public CustomerDto updateCustomer(Integer id, CustomerDto customerDto) {
		Customer customer = null;
		Optional<Customer> savedCustomer = customerRepo.findById(id);
		if(savedCustomer.isPresent()) {
			customer = savedCustomer.get();
			customer.setFirstName(customerDto.getFirstName());
			customer.setLastName(customerDto.getLastName());
			customer.setAddress(customerDto.getAddress());
		}
		return customerConverter.entityToDto(customerRepo.save(customer));
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers = customerRepo.findAll();
		if(customers.isEmpty()) {
			return new ArrayList<CustomerDto>();
		} else {
			return customerConverter.entityToDto(customers);
		}
	}

	@Override
	public CustomerDto getCustomerById(Integer id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if(customer.isPresent()) {
			return customerConverter.entityToDto(customer.get());
		} else {
			return new CustomerDto();
		}
	}

}
