package com.skipthedishes.challenge.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skipthedishes.challenge.model.entity.Store;
import com.skipthedishes.challenge.model.repository.StoreRepository;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;
	
	@Override
	public Iterable<Store> findAllStores() {
		return storeRepository.findAll();
	}

	@Override
	public Optional<Store> findById(Integer storeId) {
		return storeRepository.findById(storeId);
	}

	@Override
	public List<Store> findByText(String searchText) {
		return storeRepository.findByText(searchText);
	}

	@Override
	public List<Store> findStoresByCousineId(Integer cousineId) {
		return storeRepository.findByCousineId(cousineId);
	}

}
