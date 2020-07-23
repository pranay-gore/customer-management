package com.business.customermanagement.services.impl;

import java.util.List;

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

	public CustomerDto updateCustomer(Integer id, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CustomerDto> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerDto getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
