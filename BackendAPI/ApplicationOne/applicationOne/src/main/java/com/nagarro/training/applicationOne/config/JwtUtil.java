package com.nagarro.training.applicationOne.config;

import java.security.KeyPair;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/**
 * @author shreyarathour
 * This class provides utility methods for JWT (JSON Web Token) operations.
 */
@Component
public class JwtUtil {
	
	private static final String SECRET_KEY= "exit_test_nagarro";
	private static final int TOKEN_VALIDITY = 3600*5;
	private final KeyPair keys = Keys.keyPairFor(SignatureAlgorithm.RS512);
	
	private SecretKey getSecretKey() {
		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		return key;
	}
	/**
     * Retrieves the username from the JWT token.
     *
     * @param token The JWT token.
     * @return The username extracted from the token.
     */
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
		
	}
	/**
     * Retrieves a claim from the JWT token.
     *
     * @param token         The JWT token.
     * @param claimResolver The function that resolves the claim from the token's claims.
     * @param <T>           The type of the claim.
     * @return The resolved claim.
     */
	//higher order function that get or return a function as a parameter
	private <T> T getClaimFromToken(String token, Function<Claims,T> claimResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		
		return claimResolver.apply(claims);
		
	}
	/**
     * Retrieves all claims from the JWT token.
     *
     * @param token The JWT token.
     * @return The claims extracted from the token.
     */
	private Claims getAllClaimsFromToken(String token) {
		//String base64Key = Encoders.BASE64.encode(getSecretKey().getEncoded());
		return Jwts.parserBuilder().setSigningKey(keys.getPublic())
				.build().parseClaimsJws(token).getBody();
	}
	 /**
     * Validates the JWT token against a user's details.
     *
     * @param token       The JWT token.
     * @param userDetails The user details for validation.
     * @return True if the token is valid, false otherwise.
     */
	public boolean validateToken(String token, UserDetails userDetails) {
		String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	/**
     * Checks if the JWT token is expired.
     *
     * @param token The JWT token.
     * @return True if the token is expired, false otherwise.
     */
	private boolean isTokenExpired(String token) {
		final Date expirationDate = getExpirationDateFromToken(token);
		return expirationDate.before(new Date());
	}
	/**
     * Retrieves the expiration date from the JWT token.
     *
     * @param token The JWT token.
     * @return The expiration date of the token.
     */
	private Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	 /**
     * Generates a JWT token for a user.
     *
     * @param userDetails The user details for whom the token is generated.
     * @return The generated JWT token.
     */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY*1000))
				.signWith(keys.getPrivate()).compact();
	}

}
