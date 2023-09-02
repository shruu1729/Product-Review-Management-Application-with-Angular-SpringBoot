package com.nagarro.training.applicationOne.service.impl;

import com.nagarro.training.applicationOne.service.ProductService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.applicationOne.dao.ProductDao;
import com.nagarro.training.applicationOne.model.Product;
/**
 * ProductServiceImpl class is a service implementation that provides methods for retrieving, 
 * searching, adding, and counting products.
 * @author shreyarathour
 *
 */
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	/**
	 * Retrieves all products.
	 *
	 * @return the list of all products
	 */
	@Override
	public List<Product> getAllProducts(){
		return this.productDao.findAll ();
	}
	/**
	 * Searches for products based on the provided search key.
	 *
	 * @param searchKey the search key to match against product name or product ID
	 * @return the list of products matching the search key
	 */
	@Override
	public List<Product> search(String searchKey){
		return this.productDao.findProductByProductNameOrProductId(searchKey);
		
	}
	/**
	 * Retrieves a product by its ID.
	 *
	 * @param productId the ID of the product to retrieve
	 * @return the product with the specified ID, or null if not found
	 */
	@Override
	public Product getProductByProductId(String productId) {
		return this.productDao.findProductByProductId(productId);
	}
	/**
	 * Counts the total number of products.
	 *
	 * @return the count of products
	 */
	@Override
	public Long countProducts() {
		return this.productDao.count();
	}
	/**
	 * Adds a new product.
	 *
	 * @param product the product to add
	 * @return the added product, or null if a product with the same ID already exists
	 */
	@Override
	public Product addProduct(Product product) {
		// Check if a product with the same ID already exists
		Product prod = this.productDao.findProductByProductId(product.getProductId());
		
		if(prod!=null) {
			return null;
		}
		// Save the new product to the database
		return this.productDao.save(product);
		
	}
}
