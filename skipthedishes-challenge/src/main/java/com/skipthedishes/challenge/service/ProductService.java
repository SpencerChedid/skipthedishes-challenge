package com.skipthedishes.challenge.service;

import java.util.List;
import java.util.Optional;

import com.skipthedishes.challenge.model.entity.Product;

public interface ProductService {

	Iterable<Product> findAllProducts();

	Optional<Product> findById(Integer id);

	List<Product> findByText(String searchText);

	List<Product> findProductsByStoreId(Integer storeId);

}
