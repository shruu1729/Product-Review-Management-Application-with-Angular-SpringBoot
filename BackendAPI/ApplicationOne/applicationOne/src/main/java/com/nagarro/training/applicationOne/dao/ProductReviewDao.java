package com.nagarro.training.applicationOne.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.training.applicationOne.model.ProductReview;
/**
 * ProductReviewDao provides data access methods to interact with the underlying database for the ProductReview entity.
 * @author shreyarathour
 *
 */
@Repository
public interface ProductReviewDao extends JpaRepository<ProductReview, String> {
	/**
     * Retrieves a product review by its review ID.
     *
     * @param reviewId The review ID.
     * @return The product review with the specified ID.
     */
	ProductReview findByReviewId(String reviewId);

}
