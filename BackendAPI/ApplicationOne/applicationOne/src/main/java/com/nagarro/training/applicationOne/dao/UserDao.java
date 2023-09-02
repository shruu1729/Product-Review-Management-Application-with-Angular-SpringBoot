package com.nagarro.training.applicationOne.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.training.applicationOne.model.User;
/**
 * Spring Data JPA repository interface  UserDao extends the JpaRepository interface, which provides generic CRUD operations for the User entity.
 * @author shreyarathour
 *
 */
public interface UserDao extends JpaRepository<User, Long> {
	 /**
     * Retrieves a user by their email.
     *
     * @param email The email of the user.
     * @return The user with the specified email.
     */
	User findByEmail(String email);

    // This interface extends the JpaRepository interface,
    // providing generic CRUD operations
    // for the User entity.

    // The UserDao interface is used for data access operations
    // related to the User entity.

    // The additional method findByEmail() is defined to retrieve
    // a specific user by their email address.

}