package com.nagarro.training.applicationOne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.applicationOne.model.ProductReview;
import com.nagarro.training.applicationOne.service.ProductReviewService;
/**
 * ProductReviewController class is a Spring REST controller that handles HTTP requests related to product reviews
 * @author shreyarathour
 *
 */
@RestController
@RequestMapping("/api")
public class ProductReviewController {
	
	@Autowired 
	private ProductReviewService productReviewService;
	/**
     * Endpoint to add a review for a product.
     *
     * @param review    The review object to be added.
     * @param productId The ID of the product for which the review is added.
     * @return ResponseEntity indicating the success status of the operation.
     */
	@PostMapping("/add-review/{productId}")
	public ResponseEntity addReview(@RequestBody ProductReview review, @PathVariable String productId) {
		this.productReviewService.addReview(review, productId);
		return ResponseEntity.status(200).build();
	}
	 /**
     * Endpoint to update the state of a review by an admin.
     *
     * @param reviewId The ID of the review to be updated.
     * @param state    The new state of the review.
     * @return ResponseEntity indicating the success status of the operation.
     */
	@PostMapping("/admin/update/{reviewId}")
	public ResponseEntity updateReview(@PathVariable String reviewId, @RequestBody String state) {
		this.productReviewService.updateState(reviewId, state);
		return ResponseEntity.ok().build();
	}
	/**
     * Endpoint to count the number of product reviews.
     *
     * @return The count of product reviews.
     */
	@GetMapping("/productReviews/count")
    public long countProductReviews() {

        return this.productReviewService.countProductReviews();

    }

 

}
