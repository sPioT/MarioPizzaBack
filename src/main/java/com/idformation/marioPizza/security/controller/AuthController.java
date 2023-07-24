package com.idformation.marioPizza.security.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idformation.marioPizza.security.controller.dto.AccountRequest;
import com.idformation.marioPizza.security.controller.dto.JwtResponse;
import com.idformation.marioPizza.security.controller.dto.LoginRequest;
import com.idformation.marioPizza.security.controller.mapper.AccountMapper;
import com.idformation.marioPizza.security.jwt.JwtProvider;
import com.idformation.marioPizza.security.service.UserDetailsServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:19000/", maxAge = 3600)
@RequestMapping("/auth")
public class AuthController {

	private Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

	@Value("${app.jwtTokenHeader}")
	private String tokenHeader;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtProvider tokenProvider;

	@Autowired
	private UserDetailsServiceImpl userService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		LOGGER.debug(loginRequest.getUsername());

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);

		return ResponseEntity.ok(new JwtResponse(jwt, tokenHeader));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> createAccount(@Valid @RequestBody AccountRequest request) {

		//1 create account

		try {

			userService.createAccount(AccountMapper.toEntity(request));

		} catch (Exception e) {
			//someting went wrong, return an error
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}


		//2 if creation is OK the authenticate;

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getTelephone(), request.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);

		return ResponseEntity.ok(new JwtResponse(jwt, tokenHeader));
	}

}
