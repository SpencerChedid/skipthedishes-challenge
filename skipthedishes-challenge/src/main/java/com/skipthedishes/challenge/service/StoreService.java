package com.skipthedishes.challenge.service;

import java.util.List;
import java.util.Optional;

import com.skipthedishes.challenge.model.entity.Store;

public interface StoreService {

	Iterable<Store> findAllStores();

	Optional<Store> findById(Integer id);

	List<Store> findByText(String searchText);
	
	List<Store> findStoresByCousineId(Integer cousineId);

}
