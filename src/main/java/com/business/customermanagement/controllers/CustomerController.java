package com.business.customermanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}
