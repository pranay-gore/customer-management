package com.business.customermanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.customermanagement.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String string, String string2);

	List<Customer> findByFirstNameIgnoreCase(String string);

	List<Customer> findByLastNameIgnoreCase(String string);

}
