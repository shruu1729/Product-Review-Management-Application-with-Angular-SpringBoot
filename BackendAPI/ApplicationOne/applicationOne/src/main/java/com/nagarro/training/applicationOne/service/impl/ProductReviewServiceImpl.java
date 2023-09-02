package com.nagarro.training.applicationOne.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.applicationOne.dao.ProductReviewDao;
import com.nagarro.training.applicationOne.model.Product;
import com.nagarro.training.applicationOne.model.ProductReview;

import com.nagarro.training.applicationOne.service.ProductReviewService;
import com.nagarro.training.applicationOne.service.ProductService;
/**
 * ProductReviewServiceImpl class is a service implementation that provides methods for adding a product review, 
 * updating the state of a review, and counting the total number of product reviews.
 * @author shreyarathour
 *
 */
@Service
public class ProductReviewServiceImpl implements ProductReviewService {
	
	@Autowired
	private ProductReviewDao productReviewDao;
	
	@Autowired
	private ProductService productService;
	/**
	 * Adds a new product review.
	 *
	 * @param review   the product review to add
	 * @param reviewId the ID of the product associated with the review
	 * @return the added product review
	 */
	@Override
	public ProductReview addReview(ProductReview review, String reviewId) {
		// Retrieve the product associated with the review
		Product product = this.productService.getProductByProductId(reviewId);
		// Add the review to the product's review list
		product.getReview().add(review);
		// Update the product with the new review
		this.productService.addProduct(product);
		// Set the product reference and initial state for the review
		review.setProduct(product);
		review.setState("false");
		// Save the review to the database
		this.productReviewDao.save(review);
		return review;
	}
	/**
	 * Updates the state of a product review.
	 *
	 * @param reviewId the ID of the review to update
	 * @param state    the new state value
	 */
	@Override
	public void updateState(String reviewId, String state) {
		// Retrieve the review by its ID
		ProductReview review = this.productReviewDao.findByReviewId(reviewId);
		// Update the state of the review
		review.setState(state);
		// Save the updated review to the database
		this.productReviewDao.save(review);
	}
	/**
	 * Counts the total number of product reviews.
	 *
	 * @return the count of product reviews
	 */
	@Override
    public long countProductReviews() {
        return this.productReviewDao.count();

    }

}
