package com.idformation.marioPizza.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.idformation.marioPizza.security.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Find a User by its username (phonenumber in our case).
	 *
	 * @param username the phonenumber of the user
	 * @return the User
	 */
	@Query(value = "select u from User u where phonenumber = :username")
	Optional<User> findByUsername(String username);

}
