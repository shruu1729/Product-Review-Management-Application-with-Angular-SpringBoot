package com.nagarro.training.applicationOne.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.training.applicationOne.dao.UserDao;
import com.nagarro.training.applicationOne.model.User;
/**
 * The UserDetailsServiceImpl class is a service implementation that implements the UserDetailsService interface.
 * It is responsible for loading user details by username for authentication and authorization purposes.
 * @author shreyarathour
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	/**
	 * Loads user details by username.
	 *
	 * @param username the username of the user
	 * @return the UserDetails object representing the user
	 * @throws UsernameNotFoundException if the username is not found
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = this.userDao.findByEmail(username);
		 if(user!=null) {
			 return new org.springframework.security.core.userdetails.User(
					 user.getEmail(), user.getPassword(),getAuthorities(user));
		 }else {
			 throw new UsernameNotFoundException("username is not valid");
		 }
	}
	/**
	 * Retrieves the authorities (roles) for the user.
	 *
	 * @param user the user object
	 * @return the set of authorities (roles)
	 */
	private Set getAuthorities(User user) {
		Set authorities = new HashSet<>();
		
		user.getRoles().forEach(role->{
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
		});
		
		return authorities;
		
	}
	
	
}
