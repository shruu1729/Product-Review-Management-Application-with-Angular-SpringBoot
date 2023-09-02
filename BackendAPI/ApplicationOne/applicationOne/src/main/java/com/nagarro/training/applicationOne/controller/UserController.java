package com.nagarro.training.applicationOne.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.applicationOne.model.User;
import com.nagarro.training.applicationOne.service.UserService;
/**
 * UserController handles various HTTP requests related to user management within the /api/user endpoint.
 * @author shreyarathour
 *
 */
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	 /**
     * Retrieves all users.
     *
     * @return List of all users.
     */
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return this.userService.getUsers();
	}
	  /**
     * Retrieves a user by their ID.
     *
     * @param userId The ID of the user.
     * @return The user with the specified ID.
     */
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable String userId) {
		return this.userService.getUser(Long.parseLong(userId));
	}
	/**
     * Registers a new user.
     *
     * @param user The user object to be registered.
     */
	@PostMapping("/user")
	public void register(@RequestBody User user) {
		this.userService.addUser(user);
	}
	/**
     * Counts the total number of users.
     *
     * @return The total number of users.
     */
	@GetMapping("/user/count")
	public Long countUser() {
		return this.userService.countUsers();
	}
}
