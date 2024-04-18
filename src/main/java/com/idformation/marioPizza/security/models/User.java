package com.idformation.marioPizza.security.models;

import java.util.HashSet;
import java.util.Set;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	/** technical id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** username aka login. */
	@NonNull
	private String phonenumber = "...";

	/** password. */
	@NonNull
	private String password = "...";

	/** firstname. */
	@NonNull
	private String firstname = "...";

	/** lastname. */
	@NonNull
	private String lastname = "...";

	/** address. */
	@NonNull
	private String address = "...";

	/** roles of the user. */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	/**
	 *
	 */
	public User() {
		super();
	}

	/**
	 * Constructor from parameters.
	 *
	 * @param pId          the id
	 * @param pPhonenumber the phonenumber
	 * @param pPassword    the password
	 * @param pFirstname   the firstname
	 * @param pLastname    the lastname
	 * @param pAddress     the adress
	 */
	public User(final Long pId, final String pPhonenumber, final String pPassword, final String pFirstname,
			final String pLastname, final String pAddress) {
		super();
		this.id = pId;
		this.phonenumber = pPhonenumber;
		this.password = pPassword;
		this.firstname = pFirstname;
		this.lastname = pLastname;
		this.address = pAddress;
	}

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
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the lastname
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
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @return the phonenumber
	 */
	public String getUsername() {
		return phonenumber;
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
	 * @param pId the id to set
	 */
	public void setId(final Long pId) {
		this.id = pId;
	}

	/**
	 * @param pLastname the lastname to set
	 */
	public void setLastname(final String pLastname) {
		this.lastname = pLastname;
	}

	/**
	 * @param pPassword the password to set
	 */
	public void setPassword(final String pPassword) {
		this.password = pPassword;
	}

	/**
	 * @param pPhonenumber the phonenumber to set
	 */
	public void setPhonenumber(final String pPhonenumber) {
		this.phonenumber = pPhonenumber;
	}

	/**
	 * @param pRoles the roles to set
	 */
	public void setRoles(final Set<Role> pRoles) {
		this.roles = pRoles;
	}

	/**
	 * @param pPhonenumber the phonenumber to set
	 */
	public void setUsername(final String pPhonenumber) {
		this.phonenumber = pPhonenumber;
	}

}
