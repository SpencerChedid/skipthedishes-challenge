package com.skipthedishes.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.skipthedishes.challenge.model.entity.Cousine;
import com.skipthedishes.challenge.model.entity.Store;
import com.skipthedishes.challenge.service.CousineService;
import com.skipthedishes.challenge.service.StoreService;

/**
 * Controller for Cousine
 * 
 * @author Spencer Chedid
 * @date 18/03/2018
 */
@RestController
public class CousineController {

	@Autowired
	private CousineService cousineService;
	
	@Autowired
	private StoreService storeService;
	
	/**
	 * Retrieves all cousine
	 * @return Iterable<Cousine>
	 */
	@GetMapping(path = "/cousine")
	public ResponseEntity<?> getAllCousine() {
		Iterable<Cousine> list = cousineService.findAllCousine();
		return new ResponseEntity<Iterable<Cousine>>(list, HttpStatus.OK);
	}
	
	/**
	 * Retrieves a collection of cousine that contains the given text param 
	 * @param searchText
	 * @return ResponseEntity<List<Cousine>>
	 */
	@GetMapping(path = "/cousine/search/{searchText}")
	public ResponseEntity<?> getCousineByText(@PathVariable("searchText") String searchText) {
		List<Cousine> cousine = cousineService.findByText(searchText);
		if (cousine.isEmpty())
			return new ResponseEntity<String>("No cousine with the given text was found.", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Cousine>>(cousine, HttpStatus.OK);
	}
	
	/**
	 * Retrieves a collection of stores related to the given cousine id param 
	 * @param cousineId
	 * @return ResponseEntity<List<Store>>
	 */
	@GetMapping(path = "/cousine/{id}/stores")
	public ResponseEntity<?> getStoresByCousineId(@PathVariable("id") Integer cousineId) {
		List<Store> stores = storeService.findStoresByCousineId(cousineId);
		if (stores.isEmpty())
			return new ResponseEntity<String>("No stores were found for the current cousine.", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
	}
	
}
