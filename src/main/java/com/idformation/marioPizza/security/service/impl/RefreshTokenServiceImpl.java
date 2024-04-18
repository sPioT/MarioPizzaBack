package com.idformation.marioPizza.security.service.impl;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.idformation.marioPizza.security.jwt.exception.TokenRefreshException;
import com.idformation.marioPizza.security.models.RefreshToken;
import com.idformation.marioPizza.security.repository.RefreshTokenRepository;
import com.idformation.marioPizza.security.repository.UserRepository;
import com.idformation.marioPizza.security.service.IRefreshTokenService;

import jakarta.transaction.Transactional;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService {
	/** Refresh Token duration. */
	@Value("${app.jwtExpirationInMs}")
	private Long refreshTokenDurationMs;

	/** the refresh token repository. */
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

	/** the repository. */
	@Autowired
	private UserRepository userRepository;

	/**
	 * .
	 */
	@Override
	@Transactional
	public void deleteExpired() {
		refreshTokenRepository.deleteByExpirityDateBefore(Instant.now());
	}

	/**
	 * .
	 */
	@Override
	public Optional<RefreshToken> findByToken(final String token) {
		return refreshTokenRepository.findByToken(token);
	}

	/**
	 * .
	 */
	@Override
	@Transactional
	public RefreshToken createRefreshToken(final Long userId) {

		RefreshToken refreshToken = new RefreshToken();

		refreshToken.setUser(userRepository.findById(userId).get());
		refreshToken.setExpirityDate(Instant.now().plusMillis(refreshTokenDurationMs));
		refreshToken.setToken(UUID.randomUUID().toString());

		refreshToken = refreshTokenRepository.save(refreshToken);
		return refreshToken;
	}

	/**
	 * .
	 */
	@Override
	@Transactional
	public RefreshToken verifyExpiration(final RefreshToken token) {
		if (token.getExpirityDate().isBefore(Instant.now())) {
			refreshTokenRepository.delete(token);
			throw new TokenRefreshException(token.getToken(),
					"Refresh token was expired. Please make a new signin request");
		}

		return token;
	}

	/**
	 * .
	 */
	@Override
	@Transactional
	public int deleteByUserId(final Long userId) {
		return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
	}
}
