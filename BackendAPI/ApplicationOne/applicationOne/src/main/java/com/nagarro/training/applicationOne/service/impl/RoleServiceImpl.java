package com.nagarro.training.applicationOne.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.applicationOne.dao.RoleDao;
import com.nagarro.training.applicationOne.model.Role;
import com.nagarro.training.applicationOne.service.RoleService;
/**
 * RoleServiceImpl class is a service implementation that provides methods for adding, 
 * retrieving, updating, and deleting roles
 * @author shreyarathour
 *
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	public RoleDao roleDao;
	/**
	 * Adds a new role.
	 *
	 * @param role the role to add
	 */
	@Override
	public void addRole(Role role) {
		roleDao.save(role);
	}
	/**
	 * Retrieves all roles.
	 *
	 * @return the list of all roles
	 */
	@Override
	public List<Role> getRoles(){
		return roleDao.findAll();
	}
	/**
	 * Retrieves a role by its ID.
	 *
	 * @param roleId the ID of the role to retrieve
	 * @return the role with the specified ID, or null if not found
	 */
	@Override
	public Role getRole(Long roleId) {
		if(roleDao.existsById(roleId)) {
			return roleDao.getReferenceById(roleId);
		}
		return null;
	}
	/**
	 * Updates an existing role.
	 *
	 * @param role the role to update
	 */
	@Override
	public void updateRole(Role role) {
		roleDao.save(role);
	}
	/**
	 * Deletes a role by its ID.
	 *
	 * @param roleId the ID of the role to delete
	 */
	@Override
	public void deleteRole(Long roleId) {
		Role role = roleDao.getReferenceById(roleId);
		roleDao.delete(role);
	}

}
