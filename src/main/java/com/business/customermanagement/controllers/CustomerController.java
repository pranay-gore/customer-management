package com.business.customermanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.services.CustomerService;

/**
 * The Class CustomerController - Rest Controller where services are exposed 
 * to perform operations on customer resource
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * Adds the customer
	 * 
	 * @param customerDto the customer who needs to be added
	 * @return customer with its newly generated id
	 */
	@PostMapping
	public CustomerDto addCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.addCustomer(customerDto);
	}
	
	/**
	 * Update the customer.
	 *
	 * @param id - id of the existing customer
	 * @param customerDto the customer with updated information
	 * @return updated customer with its id
	 */
	@PutMapping("/{id}")
	public CustomerDto updateCustomer(@PathVariable Integer id, @RequestBody CustomerDto customerDto) {
		return customerService.updateCustomer(id, customerDto);
	}
	
	/**
	 * Gets the customer by id
	 *
	 * @param id - id of the customer
	 * @return the customer from the database if it exists
	 */
	@GetMapping("/{id}")
	public CustomerDto getCustomerById(@PathVariable Integer id) {
		return customerService.getCustomerById(id);
	}
	
	/**
	 * Gets the customers
	 *
	 * @param firstName - the first name of the customer
	 * @param lastName - the last name of the customer
	 * @return the list of customers matching with given criteria if any exists
	 */
	@GetMapping
	public List<CustomerDto> getCustomers(@RequestParam(name = "fname") Optional<String> firstName,@RequestParam(name = "lname") Optional<String> lastName) {
		if(!firstName.isPresent() && !lastName.isPresent()) {
			return customerService.getAllCustomers();
		} else {
			return customerService.getByCustomerName(firstName, lastName);
		}
	}
}
