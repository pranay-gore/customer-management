package com.business.customermanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public CustomerDto addCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.addCustomer(customerDto);
	}
	
	@PutMapping("/{id}")
	public CustomerDto updateCustomer(@PathVariable Integer id, @RequestBody CustomerDto customerDto) {
		return customerService.updateCustomer(id, customerDto);
	}
	
	@GetMapping("/{id}")
	public CustomerDto getCustomerById(@PathVariable Integer id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping
	public List<CustomerDto> getCustomers() {
		return customerService.getAllCustomers();
	}
}
