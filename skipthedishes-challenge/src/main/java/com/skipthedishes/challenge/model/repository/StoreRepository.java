package com.skipthedishes.challenge.model.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.skipthedishes.challenge.model.entity.Store;

public interface StoreRepository extends CrudRepository<Store, Integer> {

	@Query(value = "SELECT s FROM Store s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :searchText, '%'))")
	@Cacheable("storesByText")
	public List<Store> findByText(@Param("searchText") String searchText);
	
	@Query(value = "SELECT s FROM Store s INNER JOIN Cousine c ON c.id = s.cousine.id WHERE c.id = :cousineId ")
	public List<Store> findByCousineId(@Param("cousineId") Integer cousineId);
	
}
