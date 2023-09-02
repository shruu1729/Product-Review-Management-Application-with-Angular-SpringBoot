package com.nagarro.training.applicationOne.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
/**
 * ProductReview class represents a product review entity
 * @author shreyarathour
 *
 */
@Entity
@Table(name="productReview")
public class ProductReview {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="review_id")
	private String reviewId;
	private String review;
	private String state;
	private int rating; 
	
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	@ManyToOne
	private Product product;
	/**
	 * Gets the review ID.
	 * @return the review ID
	 */
	public String getReviewId() {
		return reviewId;
	}
	/**
	 * Sets the review ID.
	 * @param reviewId the review ID to set
	 */
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	/**
	 * Gets the review content.
	 * @return the review content
	 */
	public String getReview() {
		return review;
	}
	/**
	 * Sets the review content.
	 * @param review the review content to set
	 */
	public void setReview(String review) {
		this.review = review;
	}

	/**
	 * Gets the state of the review.
	 * @return the review state
	 */
	public String getState() {
		return state;
	}
	/**
	 * Sets the state of the review.
	 * @param state the review state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * Gets the associated product.
	 * @return the associated product
	 */
	@JsonBackReference
	public Product getProduct() {
		return product;
	}
	/**
	 * Sets the associated product.
	 * @param product the product to set
	 */

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductReview [reviewId=" + reviewId + ", review=" + review + ", state=" + state + ", product="
				+ product + "]";
	}
	
	

}
