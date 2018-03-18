package com.skipthedishes.challenge.service;

import java.util.List;

import com.skipthedishes.challenge.model.entity.Cousine;

public interface CousineService {

	Iterable<Cousine> findAllCousine();
	
	List<Cousine> findByText(String searchText);
	
}
