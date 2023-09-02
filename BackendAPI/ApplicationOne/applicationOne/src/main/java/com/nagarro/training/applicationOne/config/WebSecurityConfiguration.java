package com.nagarro.training.applicationOne.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.nagarro.training.applicationOne.service.impl.UserDetailsServiceImpl;
/**
 * @author shreyarathour
 * This class provides the configuration for web security.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {
	
	@Autowired
	private JwtAuthEntryPoint jwtAuthEntryPoint;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired 
	private UserDetailsServiceImpl userDetailsService;
	 /**
     * Configures the authentication manager bean.
     *
     * @param authConfiguration The authentication configuration.
     * @return The authentication manager.
     * @throws Exception If an exception occurs while configuring the authentication manager.
     */
	@Bean
	public AuthenticationManager authenticationManager(
								AuthenticationConfiguration authConfiguration) 
										throws Exception {
		
	  return authConfiguration.getAuthenticationManager();
	}
	/**
     * Configures the password encoder bean.
     *
     * @return The password encoder.
     */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    /**
     * Configures the authentication provider bean.
     *
     * @return The authentication provider.
     */
	@Bean
	  public DaoAuthenticationProvider authenticationProvider() {
	      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	       
	      authProvider.setUserDetailsService(userDetailsService);
	      authProvider.setPasswordEncoder(passwordEncoder());
	   
	      return authProvider;
	  }
	/**
     * Configures the security filter chain.
     *
     * @param http The HTTP security configuration.
     * @return The security filter chain.
     * @throws Exception If an exception occurs while configuring the security filter chain.
     */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        // Enable Cross-Origin Resource Sharing (CORS)
		http.cors();
		// Disable CSRF (Cross-Site Request Forgery) protection
		http.csrf().disable()
			.authorizeRequests()
			// Allow access to certain endpoints without authentication
			.antMatchers("/api/authenticate","/api/user/**","/api/role/**,/",
					"/api/products/count", "/api/productReviews/count").permitAll()
			  // Allow pre-flight requests
			.antMatchers(HttpHeaders.ALLOW).permitAll()
            // Require authentication for any other endpoint
			.anyRequest().authenticated()
			.and()
			.exceptionHandling().authenticationEntryPoint(this.jwtAuthEntryPoint)
			.and()
			// Set session management to stateless
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			;
		// Set the authentication provider
		http.authenticationProvider(authenticationProvider());

        // Add the JWT request filter before the UsernamePasswordAuthenticationFilter
		http.addFilterBefore(this.jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		// Build and return the SecurityFilterChain
		return http.build();		
	}
}
