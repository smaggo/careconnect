package com.samitamaggo.careconnect.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
/**
 * This is authority entity.
 */
@Entity(name = "authority")
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "authority", nullable = false)
	@Enumerated(EnumType.STRING)
	private AuthorityRole authorityRole;
	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, targetEntity = User.class)
//	@JoinColumn(name = "User_id")
//    private User user;
	/**
	 * <p>Constructor for Authority.</p>
	 */
	public Authority() {
		// default constructor
	}

	/**
	 * <p>Getter for the field <code>id</code>.</p>
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * <p>Setter for the field <code>id</code>.</p>
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * <p>Getter for the field <code>authorityRole</code>.</p>
	 *
	 * @return the authorityRole
	 */
	public AuthorityRole getAuthorityRole() {
		return authorityRole;
	}

	/**
	 * <p>Setter for the field <code>authorityRole</code>.</p>
	 *
	 * @param authorityRole
	 *            the authorityRole to set
	 */
	public void setAuthorityRole(AuthorityRole authorityRole) {
		this.authorityRole = authorityRole;
	}
}
