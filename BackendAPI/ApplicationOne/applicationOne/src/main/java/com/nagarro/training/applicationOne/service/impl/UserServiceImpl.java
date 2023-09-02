package com.nagarro.training.applicationOne.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nagarro.training.applicationOne.dao.UserDao;
import com.nagarro.training.applicationOne.model.Role;
import com.nagarro.training.applicationOne.model.User;
import com.nagarro.training.applicationOne.service.UserService;
/**
 * The UserServiceImpl class implements the UserService interface. 
 * It provides implementations for methods to retrieve users,
 * add a new user, and count the number of users.
 * @author shreyarathour
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	/**
	 * Retrieves all users.
	 *
	 * @return the list of all users
	 */
	
	@Override
	public List<User> getUsers(){
		return this.userDao.findAll();
	}
	/**
	 * Retrieves a user by ID.
	 *
	 * @param userId the ID of the user to retrieve
	 * @return the user with the specified ID, or null if not found
	 */
	@Override
	public User getUser(Long userId) {
		if(this.userDao.existsById(userId)){
			return this.userDao.findById(userId).get();
		}
		return null;
	}
	/**
	 * Adds a new user.
	 *
	 * @param user the user to add
	 */
	@Override
	public void addUser(User user) {
		Set<Role> roles= new HashSet<>();
		Role role = new Role();
		role.setName("USER");
		role.setId(2L);
		roles.add(role);
		user.setRoles(roles);
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		this.userDao.save(user);
		
	}
	/**
	 * Counts the number of users.
	 *
	 * @return the total number of users
	 */
	@Override
	public Long countUsers() {
		return this.userDao.count();
	}

}
