package com.nagarro.training.applicationOne.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nagarro.training.applicationOne.model.Product;
import org.springframework.data.jpa.repository.Query;
/**
 * ProductDao is Spring Data JPA repository which provides data access methods to interact with the database for the Product entity.
 * @author shreyarathour
 *
 */
@Repository
public interface ProductDao extends JpaRepository<Product, String> {
	/**
     * Custom query to search for products based on the product name, product ID, or color.
     *
     * @param query The search query.
     * @return List of products matching the search criteria.
     */
	@Query("SELECT p  FROM Product p WHERE "+
			"p.productName LIKE CONCAT('%',:query, '%')" +
			"Or p.productId LIKE CONCAT('%',:query, '%')" + 
			"Or p.color LIKE CONCAT('%',:query, '%')")
	public List<Product> findProductByProductNameOrProductId(String query);

    /**
     * Retrieves a product by its product ID.
     *
     * @param productId The product ID.
     * @return The product with the specified ID.
     */
	public Product findProductByProductId(String productId);
}

