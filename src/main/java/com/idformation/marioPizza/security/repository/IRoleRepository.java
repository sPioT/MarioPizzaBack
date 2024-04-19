package com.idformation.marioPizza.security.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idformation.marioPizza.security.models.Role;
import com.idformation.marioPizza.security.models.RoleName;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

	/**
	 * Find Role base on a name.
	 *
	 * @param role a rolename
	 * @return roles matchning the name
	 */
	Set<Role> findRoleByName(RoleName role);

}
