package com.skipthedishes.challenge.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.skipthedishes.challenge.model.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	@Query(value = "SELECT c FROM Customer c INNER JOIN Order o ON o.id = c.orderCustomer.id WHERE o.id = :orderId")
	public List<Customer> findByOrderId(@Param("orderId") Integer orderId);
	
}
