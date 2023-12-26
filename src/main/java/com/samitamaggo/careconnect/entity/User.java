package com.samitamaggo.careconnect.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -622855600192016623L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long userId;

	@NotBlank
	@Email
	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@Transient
	private String confirmPassword;

	@Valid
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "email", referencedColumnName = "email")
	private List<Authority> authorities;

	
	public User() {
		this.authorities = new ArrayList<Authority>();
	}

	
	public Long getUserId() {
		return userId;
	}

	/**
	 * <p>Setter for the field <code>userId</code>.</p>
	 *
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * <p>Getter for the field <code>email</code>.</p>
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * <p>Setter for the field <code>email</code>.</p>
	 *
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * <p>Getter for the field <code>password</code>.</p>
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <p>Getter for the field <code>confirmPassword</code>.</p>
	 *
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * <p>Setter for the field <code>confirmPassword</code>.</p>
	 *
	 * @param confirmPassword
	 *            the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * <p>Setter for the field <code>password</code>.</p>
	 *
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	

	/**
	 * <p>Getter for the field <code>roles</code>.</p>
	 *
	 * @return the roles
	 */
	public List<Authority> getAuthorities() {
		return authorities;
	}

	/**
	 * <p>Setter for the field <code>roles</code>.</p>
	 *
	 * @param roles
	 *            the roles to set
	 */
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	// /**
	// * @return the userType
	// */
	// public UserType getUserType() {
	// return userType;
	// }
	//
	// /**
	// * @param userType
	// * the userType to set
	// */
	// public void setUserType(UserType userType) {
	// this.userType = userType;
	// }
}