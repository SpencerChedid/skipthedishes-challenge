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
import com.skipthedishes.challenge.service.ProductService;

/**
 * Controller for Product
 * 
 * @author Spencer Chedid
 * @date 18/03/2018
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	/**
	 * Retrieves all products  
	 * @return Iterable<Product>
	 */
	@GetMapping(path = "/product")
	public ResponseEntity<?> getAllProducts() {
		Iterable<Product> list = productService.findAllProducts();
		return new ResponseEntity<Iterable<Product>>(list, HttpStatus.OK);
	}
	
	/**
	 * Retrieves a collection of products that contains the given text param 
	 * @param searchText
	 * @return ResponseEntity<List<Product>>
	 */
	@GetMapping(path = "/product/search/{searchText}")
	public ResponseEntity<?> getProductsByText(@PathVariable("searchText") String searchText) {
		List<Product> products = productService.findByText(searchText);
		if (products.isEmpty())
			return new ResponseEntity<String>("No product with the given description was found.", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	/**
	 * Retrieve a product by the given id param
	 * @param id
	 * @return ResponseEntity<Product> 
	 */
	@GetMapping(path = "/product/{productId}")
	public ResponseEntity<?> getProduct(@PathVariable("productId") Integer productId) {
		Optional<Product> product = productService.findById(productId);
		if (!product.isPresent())
			return new ResponseEntity<String>("Product not found.", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
	}
		
}
