package com.business.customermanagement.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

/**
 * Represents a Customer entity.
 */
@Entity
@Data
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "address")
	private String address;
	
	@CreationTimestamp
	@Column(name = "creation_time")
	private LocalDateTime createdTime;
	
	@UpdateTimestamp
	@Column(name = "updated_time")
	private LocalDateTime updatedTime; 

}
