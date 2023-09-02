package com.nagarro.training.applicationOne.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.applicationOne.model.Product;
import com.nagarro.training.applicationOne.service.*;
/**
 * ProductController class is a Spring REST controller that handles HTTP requests related to product management.
 * @author shreyarathour
 *
 */
@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	 /**
     * Retrieves all products.
     *
     * @return List of all products.
     */
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return this.productService.getAllProducts();
	}
	 /**
     * Searches products based on the given query.
     *
     * @param query The search query.
     * @return ResponseEntity containing the list of matching products.
     */
	@GetMapping("/products/{query}")
	public ResponseEntity<List<Product>> searchProduct(@PathVariable String query){
		return ResponseEntity.ok().body(this.productService.search(query));
	}
	 /**
     * Retrieves a product by its ID.
     *
     * @param productId The ID of the product.
     * @return The product with the specified ID.
     */
	@PostMapping("/products/{productId}")
	public Product getById(@PathVariable String productId) {
		return this.productService.getProductByProductId(productId);
	}
	/**
     * Retrieves the count of all products.
     *
     * @return The count of products.
     */
	@GetMapping("/products/count")
	public Long countProducts() {
		return this.productService.countProducts();
	}

}
