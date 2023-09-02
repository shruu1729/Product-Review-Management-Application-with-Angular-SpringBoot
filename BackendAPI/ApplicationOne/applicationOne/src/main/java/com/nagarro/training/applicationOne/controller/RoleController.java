package com.nagarro.training.applicationOne.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nagarro.training.applicationOne.model.Role;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nagarro.training.applicationOne.service.RoleService;
/**
 * RoleController handles various HTTP requests related to roles within the /api/role endpoint.
 * @author shreyarathour
 *
 */
@RestController
@RequestMapping("/api")
public class RoleController {
	
	@Autowired
	public RoleService roleService;
	 /**
     * Retrieves all roles.
     *
     * @return List of all roles.
     */
	@GetMapping("/role")
	public List<Role> getAllRoles()
	{
		return this.roleService.getRoles();
	}
	  /**
     * Retrieves a role by its ID.
     *
     * @param roleId The ID of the role.
     * @return The role with the specified ID.
     */
	@GetMapping("/role/{roleId}")
	public Role getRole(@PathVariable String roleId) {
		return this.roleService.getRole(Long.parseLong(roleId));
	}
	 /**
     * Adds a new role.
     *
     * @param role The role object to be added.
     * @return ResponseEntity indicating the success status of the operation.
     */
	@PostMapping("/role")
	public ResponseEntity<HttpStatus> addRole(@RequestBody Role role){
		try {
			this.roleService.addRole(role);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 /**
     * Updates an existing role.
     *
     * @param role The updated role object.
     * @return ResponseEntity indicating the success status of the operation.
     */
	@PutMapping("/role")
	public ResponseEntity<HttpStatus> updateRole(@RequestBody Role role){
		try {
			this.roleService.updateRole(role);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 /**
     * Deletes a role by its ID.
     *
     * @param roleId The ID of the role to be deleted.
     * @return ResponseEntity indicating the success status of the operation.
     */
	@DeleteMapping("role/{roleId}")
	public ResponseEntity<HttpStatus> deleteRole(@PathVariable String roleId){
		try {
			this.roleService.deleteRole(Long.parseLong(roleId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
