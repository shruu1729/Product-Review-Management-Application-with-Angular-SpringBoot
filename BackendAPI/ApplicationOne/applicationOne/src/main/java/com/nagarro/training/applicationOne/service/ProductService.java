package com.nagarro.training.applicationOne.service;

import java.util.List;

import com.nagarro.training.applicationOne.model.Product;
/**
 * The ProductService interface defines the contract for managing products.
 *  It provides methods to retrieve all products, search for products based on a search key, retrieve a product by its ID, 
 *  count the total number of products, and add a new product.
 * @author shreyarathour
 *
 */
public interface ProductService {
	/**
	 * Retrieves all products.
	 *
	 * @return a list of all products
	 */
	List<Product> getAllProducts();
	/**
	 * Searches for products based on the given search key.
	 *
	 * @param searchKey the search key to match against product names, IDs, or colors
	 * @return a list of products matching the search key
	 */
	List<Product> search(String searchKey);

	/**
	 * Retrieves a product by its unique product ID.
	 *
	 * @param productId the ID of the product
	 * @return the product with the specified ID, or null if not found
	 */
	Product getProductByProductId(String productId);
	/**
	 * Counts the total number of products.
	 *
	 * @return the total number of products
	 */
	Long countProducts();

	/**
	 * Adds a new product.
	 *
	 * @param product the product to add
	 * @return the added product
	 */
	Product addProduct(Product product);

}
