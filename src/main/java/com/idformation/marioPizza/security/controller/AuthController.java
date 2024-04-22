package com.idformation.marioPizza.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idformation.marioPizza.security.dto.AccountRequest;
import com.idformation.marioPizza.security.dto.JwtResponse;
import com.idformation.marioPizza.security.dto.LoginRequest;
import com.idformation.marioPizza.security.dto.TokenRefreshRequest;
import com.idformation.marioPizza.security.dto.TokenRefreshResponse;
import com.idformation.marioPizza.security.dto.UserDto;
import com.idformation.marioPizza.security.dto.mapper.AccountMapper;
import com.idformation.marioPizza.security.exception.DuplicateException;
import com.idformation.marioPizza.security.jwt.JwtProvider;
import com.idformation.marioPizza.security.jwt.exception.TokenRefreshException;
import com.idformation.marioPizza.security.models.RefreshToken;
import com.idformation.marioPizza.security.models.User;
import com.idformation.marioPizza.security.service.IRefreshTokenService;
import com.idformation.marioPizza.security.service.impl.UserDetailsServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

	/** token header to use in JWT. */
	@Value("${app.jwtTokenHeader}")
	private String tokenHeader;

	/** import authentication manager. */
	@Autowired
	private AuthenticationManager authenticationManager;

	/** import jwtprovider. */
	@Autowired
	private JwtProvider tokenProvider;

	/** import refreshToken service. */
	@Autowired
	private IRefreshTokenService refreshTokenService;

	/** import user service. */
	@Autowired
	private UserDetailsServiceImpl userService;

	/**
	 *
	 * @param request a login + password couple
	 * @return a response with the jwt
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody final LoginRequest request) {

		return doAuthentication(request.getUsername(), request.getPassword());
	}

	/**
	 * Get a new token.
	 *
	 * @param request a valid refresh token
	 * @return a new token
	 */
	@PostMapping("/refreshtoken")
	public ResponseEntity<?> refreshtoken(@Valid @RequestBody final TokenRefreshRequest request) {
		String requestRefreshToken = request.getRefreshToken();

		return refreshTokenService.findByToken(requestRefreshToken).map(refreshTokenService::verifyExpiration)
				.map(RefreshToken::getUser).map(user -> {
					String jwt = tokenProvider.generateToken(user.getUsername());
					RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getId());
					return ResponseEntity.ok(new TokenRefreshResponse(tokenHeader + " " + jwt,
							tokenProvider.getExpiryDate(jwt), refreshToken.getToken()));
				})
				.orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token is not in database!"));
	}

	/**
	 * Create a new account.
	 *
	 * @param request the request containing the data for the new account
	 * @return a JWT
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> createAccount(final @Valid @RequestBody AccountRequest request) {

		// 1 create account

		try {

			userService.createAccount(AccountMapper.toEntity(request));

		} catch (DuplicateException e) {
			// something went wrong, return an error
			return new ResponseEntity<>(HttpStatus.CONFLICT);

		} catch (Exception e) {
			// something went wrong, return an error
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// 2 if creation is OK the authenticate;

		return doAuthentication(request.getTelephone(), request.getPassword());
	}

	/**
	 * Authenticate a user by his login/password.
	 *
	 * @param login    the login/username of the user
	 * @param password the password
	 * @return an authentication response
	 */
	private ResponseEntity<?> doAuthentication(final String login, final String password) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(login, password));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(login);
		User user = userService.loadUserDetails(login);

		refreshTokenService.deleteExpired();
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getId());

		return ResponseEntity.ok(new JwtResponse(tokenHeader + " " + jwt, tokenProvider.getExpiryDate(jwt),
				new UserDto(user), refreshToken.getToken()));
	}

}
