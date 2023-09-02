package com.nagarro.training.applicationOne.model;
/**
 * JwtResponse class represents a response object containing a user object and a JWT token. It is typically used as a response to successful authentication and token generation.
 * @author shreyarathour
 *
 */
public class JwtResponse {

	private User user;
	private String jwtToken;
	/**
	 * Constructs a new JwtResponse object with the provided user and JWT token.
	 *
	 * @param user The user associated with the JWT token.
	 * @param jwtToken The JWT token.
	 */
	public JwtResponse(User user, String jwtToken) {
		super();
		this.user = user;
		this.jwtToken = jwtToken;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the jwtToken
	 */
	public String getJwtToken() {
		return jwtToken;
	}

	/**
	 * @param jwtToken the jwtToken to set
	 */
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	
	
}
