package com.skipthedishes.challenge.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skipthedishes.challenge.model.entity.Customer;
import com.skipthedishes.challenge.model.entity.Order;
import com.skipthedishes.challenge.service.CustomerService;
import com.skipthedishes.challenge.service.OrderService;

/**
 * Controller for Order
 * 
 * @author Spencer Chedid
 * @date 18/03/2018
 */
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * Retrieves an order by the given id param
	 * @param id
	 * @return ResponseEntity<Order> 
	 */
	@GetMapping(path = "/order/{orderId}")
	public ResponseEntity<?> getOrder(@PathVariable("orderId") Integer orderId) {
		Optional<Order> order = orderService.findById(orderId);
		order.orElseThrow(EntityNotFoundException::new);
		return new ResponseEntity<Order>(order.get(), HttpStatus.OK);
	}
	
	/**
	 * Inserts a new order
	 * @param order
	 * @return
	 */
	@PostMapping(path = "/order")
	@ResponseBody
	public ResponseEntity<?> addOrder(@RequestBody Order order) {
		Order ord = orderService.saveOrder(order);
		if (ord == null)
			return new ResponseEntity<String>("Could not insert the order.", HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity<Order>(ord, HttpStatus.OK);
	}
	
	/**
	 * Retrieves a collection of customers by by the given order id param
	 * @param id
	 * @return ResponseEntity<Customer> 
	 */
	@GetMapping(path = "/order/{orderId}/customer")
	public ResponseEntity<?> getCustomersByOrderId(@PathVariable("orderId") Integer orderId) {
		List<Customer> customers = customerService.findByOrderId(orderId);
		if (customers.isEmpty())
			return new ResponseEntity<String>("No customers were found for the current order", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
}
