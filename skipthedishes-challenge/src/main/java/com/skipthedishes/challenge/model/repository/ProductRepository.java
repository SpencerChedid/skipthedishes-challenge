package com.skipthedishes.challenge.model.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.skipthedishes.challenge.model.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query(value = "SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :searchText, '%'))"
			+ "OR LOWER(p.description) LIKE LOWER(CONCAT('%', :searchText, '%'))")
	@Cacheable("productsByText")
	public List<Product> findByText(@Param("searchText") String searchText);
	
	@Query(value = "SELECT p FROM Product p INNER JOIN Store s ON s.id = p.store.id WHERE s.id = :storeId")
	public List<Product> findByStoreId(@Param("storeId") Integer storeId);

}
