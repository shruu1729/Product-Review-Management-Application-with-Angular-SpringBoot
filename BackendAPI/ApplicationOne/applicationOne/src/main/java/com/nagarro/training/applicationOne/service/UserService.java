package com.nagarro.training.applicationOne.service;

import java.util.List;

import com.nagarro.training.applicationOne.model.User;
/**
 * The UserService interface defines the contract for managing users. 
 * It provides methods to retrieve all users, retrieve a user by their ID, 
 * add a new user, and count the total number of users
 * @author shreyarathour
 *
 */
public interface UserService {

	/**
	 * Retrieves all users.
	 *
	 * @return a list of all users
	 */
	List<User> getUsers();
	/**
	 * Retrieves a user by their ID.
	 *
	 * @param userId the ID of the user
	 * @return the user with the specified ID, or null if not found
	 */
	User getUser(Long userId);
	/**
	 * Adds a new user.
	 *
	 * @param user the user to add
	 */
	void addUser(User user);

	/**
	 * Counts the number of users.
	 *
	 * @return the total number of users
	 */
	Long countUsers();

}