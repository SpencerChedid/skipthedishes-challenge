package com.skipthedishes.challenge.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skipthedishes.challenge.model.entity.Customer;
import com.skipthedishes.challenge.model.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Iterable<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> findByOrderId(Integer orderId) {
		return customerRepository.findByOrderId(orderId);
	}

}
