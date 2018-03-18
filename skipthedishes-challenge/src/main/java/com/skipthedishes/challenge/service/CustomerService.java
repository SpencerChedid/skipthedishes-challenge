package com.skipthedishes.challenge.service;

import java.util.List;

import com.skipthedishes.challenge.model.entity.Customer;

public interface CustomerService {
	
	Iterable<Customer> findAllCustomers();
	
	List<Customer> findByOrderId(Integer orderId);
	
}
