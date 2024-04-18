package com.idformation.marioPizza.security.dto;

public class LoginRequest {

	/** a username. */
	private String username;

	/** a password. */
	private String password;

	/**
	 *
	 */
	public LoginRequest() {
		super();
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param pPassword the password to set
	 */
	public void setPassword(final String pPassword) {
		this.password = pPassword;
	}

	/**
	 * @param pUsername the username to set
	 */
	public void setUsername(final String pUsername) {
		this.username = pUsername;
	}

}
