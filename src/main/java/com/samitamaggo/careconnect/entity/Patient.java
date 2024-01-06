package com.samitamaggo.careconnect.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
/**
 * This is patient entity.
 * It extending Person class.
 */

@Entity
@Table(name =  "patient")
public class Patient extends Person {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="id")
	private Long patientId;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="patient_id")
	private List<Appointment> appointmentList;
	
	public Patient() {
		
	}
	

	public Patient(String firstName, String lastName, Date dateOfBirth, Gender gender, String phone, User user) {
		super(firstName, lastName, dateOfBirth, gender, phone, user);
		appointmentList = new ArrayList<Appointment>();
	}


	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
	

	

}
