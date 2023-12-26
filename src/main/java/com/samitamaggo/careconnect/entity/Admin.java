package com.samitamaggo.careconnect.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Admin")
public class Admin extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long adminId;


	/**
	 * <p>Constructor for Admin</p>
	 */
	public Admin() {
		// default constructor
	}

	
	public Admin(String firstName, String lastName, Date dateOfBirth, Gender gender, String phone, User user) {
		super(firstName, lastName, dateOfBirth, gender, phone, user);
	}

	/**
	 * <p>getFullName.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getFullName() {
		return this.getFirstName() + " " + this.getLastName();
	}

	/**
	 * <p>Getter for the field <code>adminId</code>.</p>
	 *
	 * @return the adminId
	 */
	public Long getAdminId() {
		return adminId;
	}

	/**
	 * <p>Setter for the field <code>adminId</code>.</p>
	 *
	 * @param doctorId
	 *            the adminId to set
	 */
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

}
