package com.nagarro.training.applicationOne.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nagarro.training.applicationOne.constants.Constants;
/**
 * This class provides configuration for Cross-Origin Resource Sharing (CORS) in the application.
 * @author shreyarathour
 *
 */
@Configuration
public class CorsConfiguration {
/**
 * Configures CORS for the application.
 * @return the WebMvcConfigurer with CORS configuration.
*/
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			/**
			 * Adds CORS mappings to the registry.
			 *
			 * @param registry the CorsRegistry to add CORS mappings to.
			 */
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods(Constants.GET, Constants.PUT, Constants.POST, 
																	Constants.DELETE)
						.allowedHeaders("*")
						.allowedOriginPatterns("*")
						.allowCredentials(true);
				
			}
		};
	}
}

