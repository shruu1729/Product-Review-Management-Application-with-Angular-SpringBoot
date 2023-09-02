package com.nagarro.training.applicationOne.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
/**
 * Product class is a model/entity class that represents a product in the system. It is used to store and retrieve product information.
 * @author shreyarathour
 *
 */
//Specifies that certain properties should be ignored during JSON serialization and deserialization
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_id")
	private String productId;
	
	@Column(name="product_name")
	private String productName;
	private String color;
	private String gender;
	private String size;
	private Double price;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<ProductReview> review;
	/**
	 * Returns the product ID.
	 *
	 * @return The product ID.
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * Sets the product ID.
	 *
	 * @param productId The product ID to set.
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * Returns the product name.
	 *
	 * @return The product name.
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * Sets the product name.
	 *
	 * @param productName The product name to set.
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * Returns the color of the product.
	 *
	 * @return The color of the product.
	 */
	public String getColor() {
		return color;
	}
	/**
	 * Sets the color of the product.
	 *
	 * @param color The color to set.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Returns the gender associated with the product.
	 *
	 * @return The gender associated with the product.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender associated with the product.
	 *
	 * @param gender The gender to set.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}
	/**
	 * Returns the size of the product.
	 *
	 * @return The size of the product.
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * Returns the price of the product.
	 *
	 * @return The price of the product.
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * Sets the price of the product.
	 *
	 * @param price The price to set.
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Returns the list of product reviews associated with the product.
	 *
	 * @return The list of product reviews.
	 */
	@JsonManagedReference
	public List<ProductReview> getReview() {
		return review;
	}
	/**
	 * Sets the list of product reviews associated with the product.
	 *
	 * @param review The list of product reviews to set.
	 */
	public void setReview(List<ProductReview> review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", color=" + color + ", gender="
				+ gender + ", size=" + size + ", price=" + price + ", review=" + review + "]";
	}
	

}
