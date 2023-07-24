package com.idformation.marioPizza.security.controller.mapper;

import javax.validation.Valid;

import com.idformation.marioPizza.security.controller.dto.AccountRequest;
import com.idformation.marioPizza.security.models.User;

public class AccountMapper {

	public static User toEntity(@Valid AccountRequest request) {
		return new User(null, request.getTelephone(), request.getPassword(), request.getFirstname(), request.getLastname(), request.getAddress());

	}

}
