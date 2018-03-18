package com.skipthedishes.challenge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.skipthedishes.challenge.model.entity.Product;
import com.skipthedishes.challenge.model.entity.Store;
import com.skipthedishes.challenge.service.ProductService;
import com.skipthedishes.challenge.service.StoreService;

/**
 * Controller for Store
 * 
 * @author Spencer Chedid
 * @date 18/03/2018
 */
@RestController
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@Autowired
	private ProductService productService;
	
	/**
	 * Retrieves all stores
	 * @return Iterable<Store>
	 */
	@GetMapping(path = "/store")
	public ResponseEntity<?> getAllStores() {
		Iterable<Store> list = storeService.findAllStores();
		return new ResponseEntity<Iterable<Store>>(list, HttpStatus.OK);
	}
	
	/**
	 * Retrieves a collection of stores that contains the given text param 
	 * @param searchText
	 * @return ResponseEntity<List<Store>>
	 */
	@GetMapping(path = "/store/search/{searchText}")
	public ResponseEntity<?> getStoresByText(@PathVariable("searchText") String searchText) {
		List<Store> stores = storeService.findByText(searchText);
		if (stores.isEmpty())
			return new ResponseEntity<String>("No stores with the given text was found.", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
	}
	
	/**
	 * Retrieve a store by the given id param
	 * @param id
	 * @return ResponseEntity<Store> 
	 */
	@GetMapping(path = "/store/{storeId}")
	public ResponseEntity<?> getStoreById(@PathVariable("storeId") Integer storeId) {
		Optional<Store> store = storeService.findById(storeId);
		if (!store.isPresent())
			return new ResponseEntity<String>("Store not found.", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Store>(store.get(), HttpStatus.OK);
	}
	
	/**
	 * Retrieves a collection of products related to the given store id param 
	 * @param storeId
	 * @return ResponseEntity<List<Product>>
	 */
	@GetMapping(path = "/store/{storeId}/products")
	public ResponseEntity<?> getProductsByStoreId(@PathVariable("storeId") Integer storeId) {
		List<Product> products = productService.findProductsByStoreId(storeId);
		if (products.isEmpty())
			return new ResponseEntity<String>("No products were found for the current store.", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
}
