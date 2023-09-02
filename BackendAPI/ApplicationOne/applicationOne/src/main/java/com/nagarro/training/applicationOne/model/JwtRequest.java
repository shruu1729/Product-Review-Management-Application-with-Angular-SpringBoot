package com.nagarro.training.applicationOne.model;
/**
 * JwtRequest class represents a request object used for JWT authentication. It is typically used when a user wants to authenticate and obtain a JWT token.
 * @author shreyarathour
 *
 */
public class JwtRequest {
	
	private String username;
	private String userPassword;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
