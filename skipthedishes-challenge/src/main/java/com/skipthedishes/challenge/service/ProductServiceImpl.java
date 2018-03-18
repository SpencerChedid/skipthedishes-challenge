package com.skipthedishes.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skipthedishes.challenge.model.entity.Product;
import com.skipthedishes.challenge.model.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<Product> findAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public Optional<Product> findById(Integer id) {
		return productRepository.findById(id);
	}
	
	@Override
	public List<Product> findByText(String searchText) {
		return productRepository.findByText(searchText);
	}

	@Override
	public List<Product> findProductsByStoreId(Integer storeId) {
		return productRepository.findByStoreId(storeId);
	}

}
