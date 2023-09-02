package com.nagarro.training.applicationOne.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * @author shreyarathour
 * This class is a filter that intercepts incoming requests and processes JWT authentication.
 * It extends the OncePerRequestFilter class, which ensures that the filter is only executed once per request.
 */

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;

    /**
     * This method is called for each incoming request and performs the JWT authentication logic.
     *
     * @param request      The HTTP request.
     * @param response     The HTTP response.
     * @param filterChain  The filter chain for executing subsequent filters.
     * @throws ServletException If a servlet-specific exception occurs while handling the request.
     * @throws IOException      If an input or output exception occurs while handling the request.
     */
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String header = request.getHeader("Authorization");
		String username=null;
		String jwtToken=null;
		 // Check if the Authorization header is present and starts with "Bearer"
		if(header!=null && header.startsWith("Bearer ")) {
			jwtToken = header.substring(7);
			try {
				 // Get the username from the JWT token
				username = this.jwtUtil.getUsernameFromToken(jwtToken);
				
			}catch(IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			}catch(ExpiredJwtException e){
				System.out.println("Jwt Token is expired");
				
			}
		}
		else {
			System.out.println("Jwt token does not start with bearer");
		}
		 // If the username is not null and there is no existing authentication in the SecurityContextHolder
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			// Load the user details from the userDetailsService
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			// Validate the JWT token
			if(this.jwtUtil.validateToken(jwtToken, userDetails)) {
				 // Create an authentication token based on the user details
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
						new UsernamePasswordAuthenticationToken(userDetails, 
								null, userDetails.getAuthorities());
				 // Set the details of the authentication token
				usernamePasswordAuthenticationToken.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(request));
			     // Set the authentication token in the SecurityContextHolder
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			
		}
		 // Continue executing the filter chain
		filterChain.doFilter(request, response);
	}

}

