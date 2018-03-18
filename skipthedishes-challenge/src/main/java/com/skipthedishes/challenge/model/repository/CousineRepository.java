package com.skipthedishes.challenge.model.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.skipthedishes.challenge.model.entity.Cousine;

public interface CousineRepository extends CrudRepository<Cousine, Integer> {

	@Query(value = "SELECT c FROM Cousine c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :searchText, '%'))")
	@Cacheable("cousineByName")
	public List<Cousine> findByText(@Param("searchText") String searchText);

}
