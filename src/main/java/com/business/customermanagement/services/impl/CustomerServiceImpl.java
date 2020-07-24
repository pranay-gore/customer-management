package com.business.customermanagement.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.customermanagement.constants.ErrorConstant;
import com.business.customermanagement.converters.CustomerConverter;
import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.entities.Customer;
import com.business.customermanagement.exceptions.CustomerNotFoundException;
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
		if (!savedCustomer.isPresent()) {
			throw new CustomerNotFoundException(ErrorConstant.CUSTOMER_NOT_FOUND);
		}
		customer = savedCustomer.get();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setAddress(customerDto.getAddress());
		customer.setAge(customerDto.getAge());
		return customerConverter.entityToDto(customerRepo.save(customer));
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers = customerRepo.findAll();
		if (customers.isEmpty()) {
			throw new CustomerNotFoundException(ErrorConstant.CUSTOMERS_NOT_FOUND);
		} else {
			return customerConverter.entityToDto(customers);
		}
	}

	@Override
	public CustomerDto getCustomerById(Integer id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if (!customer.isPresent()) {
			throw new CustomerNotFoundException(ErrorConstant.CUSTOMER_NOT_FOUND);
		}
		return customerConverter.entityToDto(customer.get());
	}

	@Override
	public List<CustomerDto> getByCustomerName(Optional<String> firstName, Optional<String> lastName) {
		List<Customer> customers;
		if (firstName.isPresent() && lastName.isPresent()) {
			customers = customerRepo.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName.get(), lastName.get());
		} else if (firstName.isPresent()) {
			customers = customerRepo.findByFirstNameIgnoreCase(firstName.get());
		} else {
			customers = customerRepo.findByLastNameIgnoreCase(lastName.get());
		}

		if (customers.isEmpty()) {
			throw new CustomerNotFoundException(ErrorConstant.CUSTOMERS_NOT_FOUND);
		}

		return customerConverter.entityToDto(customers);
	}

}
