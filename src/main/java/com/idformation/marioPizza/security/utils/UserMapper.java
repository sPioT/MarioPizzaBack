package com.idformation.marioPizza.security.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.idformation.marioPizza.security.models.User;

public class UserMapper {

	/**
	 * Turn a User into a UserPrincipal.
	 *
	 * @param user the User
	 * @return a UserPrincipal
	 */
	public static UserPrincipal userToPrincipal(final User user) {
		UserPrincipal userp = new UserPrincipal();
		List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toList());

		userp.setUsername(user.getPhonenumber());
		userp.setPassword(user.getPassword());
		userp.setEnabled(true);
		userp.setAuthorities(authorities);
		return userp;
	}

}
