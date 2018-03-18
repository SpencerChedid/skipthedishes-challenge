package com.skipthedishes.challenge.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.skipthedishes.challenge.model.entity.OrderItem;

public interface OderItemRepository extends CrudRepository<OrderItem, Integer> {

}
