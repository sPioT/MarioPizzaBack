package com.idformation.marioPizza.security.dto.mapper;

import com.idformation.marioPizza.security.dto.AccountRequest;
import com.idformation.marioPizza.security.models.User;

import jakarta.validation.Valid;

public class AccountMapper {

	/**
	 * Map a request into a user.
	 *
	 * @param request the request
	 * @return the User extracted from the request
	 */
	public static User toEntity(@Valid final AccountRequest request) {
		return new User(null, request.getTelephone(), request.getPassword(), request.getFirstname(),
				request.getLastname(), request.getAddress());

	}

}
