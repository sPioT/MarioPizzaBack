package com.idformation.marioPizza.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.idformation.marioPizza.security.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "select u from User u where phoneNumber = :username")
	Optional<User> findByUsername(String username);

}
