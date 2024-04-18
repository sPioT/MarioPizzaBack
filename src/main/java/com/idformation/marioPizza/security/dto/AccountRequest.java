package com.idformation.marioPizza.security.dto;

public class AccountRequest {

	/** the firstname. */
	private String firstname;

	/** the lastname. */
	private String lastname;

	/** the password. */
	private String password;

	/** the phone number. */
	private String telephone;

	/** the address. */
	private String address;

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the lastName
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param pAddress the address to set
	 */
	public void setAddress(final String pAddress) {
		this.address = pAddress;
	}

	/**
	 * @param pFirstname the firstname to set
	 */
	public void setFirstname(final String pFirstname) {
		this.firstname = pFirstname;
	}

	/**
	 * @param pLastname the lastName to set
	 */
	public void setLastName(final String pLastname) {
		this.lastname = pLastname;
	}

	/**
	 * @param pPassword the password to set
	 */
	public void setPassword(final String pPassword) {
		this.password = pPassword;
	}

	/**
	 * @param pTelephone the telephone to set
	 */
	public void setTelephone(final String pTelephone) {
		this.telephone = pTelephone;
	}

}
