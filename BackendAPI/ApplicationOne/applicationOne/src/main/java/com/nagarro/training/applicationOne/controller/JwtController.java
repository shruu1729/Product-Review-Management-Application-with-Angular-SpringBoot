package com.nagarro.training.applicationOne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.applicationOne.model.JwtRequest;
import com.nagarro.training.applicationOne.model.JwtResponse;
import com.nagarro.training.applicationOne.service.impl.AuthenticateServiceImpl;
/**
 * This  is Spring REST controller that handles HTTP requests Related to JWT authentication and authorization.
 * @author shreyarathour
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class JwtController {

	@Autowired
	private AuthenticateServiceImpl authService;
	/**
     * Handles the authentication request and generates a JWT token.
     *
     * @param jwtRequest The JWT request object containing the username and password.
     * @return The JWT response object containing the generated token.
     * @throws Exception If an exception occurs during authentication.
     */
	@PostMapping("/authenticate")
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		return this.authService.createJwtToken(jwtRequest);
	}
	/**
     * Handles the request to an endpoint accessible only to users.
     *
     * @return A string indicating that the endpoint is accessible only to users.
     */
	@GetMapping("/users")
	@PreAuthorize("hasRole('USER')")
	public String forUser() {
		return "Accessible only to user";
	}
	 /**
     * Handles the request to an endpoint accessible only to admins.
     *
     * @return A string indicating that the endpoint is accessible only to admins.
     */
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String forAdmin() {
		return "Accessible only to admin";
	}

}
