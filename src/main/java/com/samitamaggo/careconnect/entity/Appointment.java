package com.samitamaggo.careconnect.entity;

import javax.validation.constraints.NotBlank;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long appointmentId;

	@NotNull
	@Column(name = "date")
	private String date;

	@NotBlank
	@Column(name = "time")
	private String time;

	@NotBlank
	@Column(name = "description")
	private String description;

	@NotNull
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private AppointmentStatus status = AppointmentStatus.NEW;


	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, targetEntity = Patient.class)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, targetEntity = Doctor.class)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	/**
	 * <p>Constructor for Appointment.</p>
	 */
	public Appointment() {
		this.patient = new Patient();
		this.doctor = new Doctor();
	}

	/**
	 * <p>Constructor for Appointment.</p>
	 *
	 * @param date a {@link java.util.Date} object.
	 * @param room a {@link java.lang.String} object.
	 * @param status a {@link mum.waa.fd.app.domain.AppointmentStatus} object.
	 */
	public Appointment(String date, AppointmentStatus status) {
		this.date = date;
		this.status = status;
	}

	/**
	 * <p>Getter for the field <code>appointmentId</code>.</p>
	 *
	 * @return the appointmentId
	 */
	public Long getAppointmentId() {
		return appointmentId;
	}

	/**
	 * <p>Setter for the field <code>appointmentId</code>.</p>
	 *
	 * @param appointmentId
	 *            the appointmentId to set
	 */
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	/**
	 * <p>Getter for the field <code>date</code>.</p>
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * <p>Setter for the field <code>date</code>.</p>
	 *
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * <p>Getter for the field <code>status</code>.</p>
	 *
	 * @return the status
	 */
	public AppointmentStatus getStatus() {
		return status;
	}

	/**
	 * <p>Setter for the field <code>status</code>.</p>
	 *
	 * @param status
	 *            the status to set
	 */
	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}


	/**
	 * <p>Getter for the field <code>time</code>.</p>
	 *
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * <p>Setter for the field <code>time</code>.</p>
	 *
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * <p>Getter for the field <code>description</code>.</p>
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <p>Setter for the field <code>description</code>.</p>
	 *
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * <p>Getter for the field <code>doctor</code>.</p>
	 *
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * <p>Setter for the field <code>doctor</code>.</p>
	 *
	 * @param doctor
	 *            the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * <p>Getter for the field <code>patient</code>.</p>
	 *
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * <p>Setter for the field <code>patient</code>.</p>
	 *
	 * @param patient
	 *            the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
