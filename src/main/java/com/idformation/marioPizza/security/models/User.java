package com.idformation.marioPizza.security.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	@Size(max = 20)
	private String phonenumber;

	@NonNull
	@Size(max = 120)
	private String password;

	@NonNull
	@Size(max = 120)
	private String firstname;

	@NonNull
	@Size(max = 120)
	private String lastname;

	@NonNull
	@Size(max = 120)
	private String address;

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
	 * @param id the id
	 * @param phonenumber the phonenumber
	 * @param password the password
	 * @param firstname the firstname
	 * @param lastname the lastname
	 * @param address the adress
	 */
	public User(Long id, @Size(max = 20) String phonenumber, @Size(max = 120) String password,
			@Size(max = 120) String firstname, @Size(max = 120) String lastname, @Size(max = 120) String address) {
		super();
		this.id = id;
		this.phonenumber = phonenumber;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
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
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setUsername(String phonenumber) {
		this.phonenumber = phonenumber;
	}



}
