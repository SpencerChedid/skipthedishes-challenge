package com.skipthedishes.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skipthedishes.challenge.model.entity.Customer;
import com.skipthedishes.challenge.service.CustomerService;

/**
 * Controller for Customer
 * 
 * @author Spencer Chedid
 * @date 18/03/2018
 */
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * Retrieves all customer
	 * 
	 * @return Iterable<Customer>
	 */
	@GetMapping(path = "/customer")
	public ResponseEntity<?> getAllCustomers() {
		Iterable<Customer> list = customerService.findAllCustomers();
		return new ResponseEntity<Iterable<Customer>>(list, HttpStatus.OK);
	}

}
