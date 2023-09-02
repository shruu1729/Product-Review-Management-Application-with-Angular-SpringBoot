package com.nagarro.training.applicationOne.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.nagarro.training.applicationOne.service.AuthenticateService;
import com.nagarro.training.applicationOne.config.JwtUtil;
import com.nagarro.training.applicationOne.dao.UserDao;
import com.nagarro.training.applicationOne.model.JwtRequest;
import com.nagarro.training.applicationOne.model.JwtResponse;
import com.nagarro.training.applicationOne.model.User;
/**
 * AuthenticateServiceImpl class is a service implementation that provides authentication-related functionality. 
 * It uses the UserDao for retrieving user information, JwtUtil for generating JWT tokens, AuthenticationManager for user authentication, 
 * UserDetailsService for loading user details.
 * @author shreyarathour
 *
 */
@Service
public class AuthenticateServiceImpl implements AuthenticateService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetails;
	/**
	 * Creates a JWT token for the provided JWT request.
	 * 
	 * @param jwtRequest the JWT request containing username and password
	 * @return JwtResponse containing the generated token and user details
	 * @throws Exception if authentication fails or user is disabled
	 */
	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception{
		String username = jwtRequest.getUsername();
		String userPassword = jwtRequest.getUserPassword();
		// Authenticate the user
		this.authenticate(username, userPassword);
		// Load user details
		final UserDetails userDetails = this.userDetails.loadUserByUsername(username);
		// Generate a new JWT token
		String newGeneratedToken = this.jwtUtil.generateToken(userDetails);
		// Retrieve the user from the database
		User user = this.userDao.findByEmail(username);
		
		return new JwtResponse(user, newGeneratedToken);
	}
	/**
	 * Authenticates the user with the provided username and password.
	 * 
	 * @param username the username to authenticate
	 * @param userPassword the user's password
	 * @throws Exception if authentication fails or user is disabled
	 */
	private void authenticate(String username, String userPassword) throws Exception {
		try {
			// Perform authentication
		this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(username, userPassword));
		}catch(DisabledException e) {
			throw new Exception("User is disabled");
		}catch(BadCredentialsException e) {
			throw new Exception("Bad credentials from user");
			
		}
	}

}

 
