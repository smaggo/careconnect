package com.samitamaggo.careconnect.entity;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Doctor")
public class Doctor extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long doctorId;

	@NotNull
	@Column(name = "specialization")
	@Enumerated(EnumType.STRING)
	private Specialization specialization;
	

	@Valid
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	private List<Appointment> appointmentList;

	/**
	 * <p>Constructor for Doctor.</p>
	 */
	public Doctor() {
		// default constructor
	}

	
	public Doctor(String firstName, String lastName, Date dateOfBirth, Gender gender, String phone, User user,
			Specialization specialization) {
		super(firstName, lastName, dateOfBirth, gender, phone, user);
		this.specialization = specialization;
		appointmentList = new ArrayList<Appointment>();
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
	 * <p>Getter for the field <code>doctorId</code>.</p>
	 *
	 * @return the doctorId
	 */
	public Long getDoctorId() {
		return doctorId;
	}

	/**
	 * <p>Setter for the field <code>doctorId</code>.</p>
	 *
	 * @param doctorId
	 *            the doctorId to set
	 */
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	
	/**
	 * <p>Getter for the field <code>specialization</code>.</p>
	 *
	 * @return the specialization
	 */
	public Specialization getSpecialization() {
		return specialization;
	}

	/**
	 * <p>Setter for the field <code>specialization</code>.</p>
	 *
	 * @param specialization
	 *            the specialization to set
	 */
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	/**
	 * <p>Getter for the field <code>appointmentList</code>.</p>
	 *
	 * @return the appointmentList
	 */
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	/**
	 * <p>Setter for the field <code>appointmentList</code>.</p>
	 *
	 * @param appointmentList
	 *            the appointmentList to set
	 */
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
}
