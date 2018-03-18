package com.skipthedishes.challenge.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skipthedishes.challenge.model.entity.Cousine;
import com.skipthedishes.challenge.model.repository.CousineRepository;

@Service
@Transactional
public class CousineServiceImpl implements CousineService {

	@Autowired
	private CousineRepository cousineRepository;

	@Override
	public Iterable<Cousine> findAllCousine() {
		return cousineRepository.findAll();
	}

	@Override
	public List<Cousine> findByText(String searchText) {
		return cousineRepository.findByText(searchText);
	}
	
}
