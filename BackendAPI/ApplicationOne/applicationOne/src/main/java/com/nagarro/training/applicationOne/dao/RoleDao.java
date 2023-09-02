package com.nagarro.training.applicationOne.dao;
import com.nagarro.training.applicationOne.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Spring Data JPA repository interface RoleDao extends the JpaRepository interface, which provides generic CRUD operations for the Role entity.
 * @author shreyarathour
 *
 */

public interface RoleDao extends JpaRepository<Role, Long> {
	// This interface does not define any additional methods.
    // It inherits the basic CRUD (Create, Read, Update, Delete) operations
    // from the JpaRepository interface.

    // The RoleDao interface is used for data access operations
    // related to the Role entity.

    // By extending JpaRepository<Role, Long>, RoleDao inherits
    // methods such as save(), findById(), findAll(), delete(), etc.

}
