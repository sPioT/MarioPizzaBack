package com.idformation.marioPizza.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idformation.marioPizza.security.models.User;
import com.idformation.marioPizza.security.repository.UserRepository;
import com.idformation.marioPizza.security.service.utils.UserMapper;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public User createAccount(User user) {

		//need to encrypt password ;)
		BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));

		return userRepository.saveAndFlush(user);

	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username).get();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
		return UserMapper.userToPrincipal(user);
	}

}
