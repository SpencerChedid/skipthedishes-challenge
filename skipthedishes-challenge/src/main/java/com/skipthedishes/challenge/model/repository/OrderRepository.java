package com.skipthedishes.challenge.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.skipthedishes.challenge.model.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
