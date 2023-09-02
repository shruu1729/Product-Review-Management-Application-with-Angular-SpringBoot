package com.nagarro.training.applicationOne.service;

import java.util.List;

import com.nagarro.training.applicationOne.model.Role;
/**
 * The RoleService interface defines the contract for managing roles. 
 * It provides methods to retrieve all roles, retrieve a role by its ID, 
 * update an existing role, delete a role by its ID, and add a new role.
 * @author shreyarathour
 *
 */
public interface RoleService {
	/**
	 * Retrieves all roles.
	 *
	 * @return a list of all roles
	 */
	List<Role> getRoles();
	/**
	 * Retrieves a role by its ID.
	 *
	 * @param roleId the ID of the role
	 * @return the role with the specified ID, or null if not found
	 */
	Role getRole(Long roleId);
	/**
	 * Updates an existing role.
	 *
	 * @param role the role to update
	 */
	void updateRole(Role role);
	/**
	 * Deletes a role by its ID.
	 *
	 * @param roleId the ID of the role to delete
	 */
	void deleteRole(Long roleId);
	/**
	 * Adds a new role.
	 *
	 * @param role the role to add
	 */
	void addRole(Role role);

}
