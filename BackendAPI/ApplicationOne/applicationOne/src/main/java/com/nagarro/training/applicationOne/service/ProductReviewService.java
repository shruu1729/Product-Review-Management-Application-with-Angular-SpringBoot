package com.nagarro.training.applicationOne.service;

import com.nagarro.training.applicationOne.model.ProductReview;
/**
 * interface for ProductReviewServiceImpl.
 * @author shreyarathour
 *
 */
public interface ProductReviewService {
	 /**
     * Adds a product review for the specified product.
     *
     * @param review    The product review to add.
     * @param productId The ID of the product.
     * @return The added product review.
     */
	ProductReview addReview(ProductReview review, String productId);
	 /**
     * Updates the state of a product review.
     *
     * @param reviewId The ID of the product review to update.
     * @param state    The new state of the product review.
     */
	void updateState(String productId, String state);
	/**
     * Retrieves the total count of product reviews.
     *
     * @return The total count of product reviews.
     */
	long countProductReviews();
	

}
