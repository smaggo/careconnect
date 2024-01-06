package com.samitamaggo.careconnect.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
/**
 * This is person class.
 * Doctor and patient class inheriting this class.
 */

@MappedSuperclass
public abstract class Person {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@NotNull
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender = Gender.MALE;

	@Column(name = "phone")
	private String phone;
   
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * <p>Constructor for Person.</p>
	 */
	public Person() {
		// default constructor
	}

	
	public Person(String firstName, String lastName, Date dateOfBirth, Gender gender, String phone, User user
			) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.user = user;
	}

	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	public Gender getGender() {
		return gender;
	}

	
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
	public String getPhone() {
		return phone;
	}

	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public User getUser() {
		return user;
	}

	
	public void setUser(User user) {
		this.user = user;
	}

}