package com.skipthedishes.challenge.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.skipthedishes.challenge.model.entity.Account;

public interface UserRepository extends CrudRepository<Account, Integer> {

	public Account findByUsername(String username);
	
}
