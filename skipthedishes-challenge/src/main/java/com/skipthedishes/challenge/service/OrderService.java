package com.skipthedishes.challenge.service;

import java.util.Optional;

import com.skipthedishes.challenge.model.entity.Order;

public interface OrderService {

	Optional<Order> findById(Integer productId);
	
	Order saveOrder (Order order);
	
}
