package com.skipthedishes.challenge.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skipthedishes.challenge.model.entity.Order;
import com.skipthedishes.challenge.model.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired 
	private OrderRepository orderRepository;
	
	@Override
	public Optional<Order> findById(Integer productId) {
		return orderRepository.findById(productId);
	}

	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

}
