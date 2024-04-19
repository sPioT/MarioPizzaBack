package com.idformation.marioPizza.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idformation.marioPizza.security.models.RoleName;
import com.idformation.marioPizza.security.models.User;
import com.idformation.marioPizza.security.repository.IRoleRepository;
import com.idformation.marioPizza.security.repository.UserRepository;
import com.idformation.marioPizza.security.utils.UserMapper;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	/** import the userRepository. */
	@Autowired
	private UserRepository userRepository;

	/** import the roleRepository. */
	@Autowired
	private IRoleRepository roleRepository;

	/**
	 * Load user's details from the DB.
	 */
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
		return UserMapper.userToPrincipal(user);
	}

	/**
	 *
	 * @param username a username
	 * @return the detail of the given user
	 * @throws UsernameNotFoundException
	 */
	public User loadUserDetails(final String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
		return user;
	}

	/**
	 * Create a new account.
	 *
	 * @param user the User to Create
	 * @return the User once fully created
	 */
	public User createAccount(final User user) {

		// need to encrypt password ;)
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));

		// add default role "USER"
		user.setRoles(roleRepository.findRoleByName(RoleName.USER));

		return userRepository.saveAndFlush(user);

	}

}
