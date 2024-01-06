package com.samitamaggo.careconnect.service;


import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.samitamaggo.careconnect.entity.Appointment;
import com.samitamaggo.careconnect.entity.Doctor;
import com.samitamaggo.careconnect.entity.Patient;
import com.samitamaggo.careconnect.entity.Specialization;
import com.samitamaggo.careconnect.repository.AppointmentRepository;
import com.samitamaggo.careconnect.repository.DoctorRepository;
import com.samitamaggo.careconnect.repository.PatientRepository;
import jakarta.transaction.Transactional;

/**
 * /**
 * This class implements the AppointmentService interface and provides the actual service(s) for a Map object. 

 */
 

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	 /**
	  * here we are implementing getAllSpecialization().
	  */
	    
	@Override
	public Map<String, String> getAllSpecialization() {

		Map<String, String> specializations = new HashMap<>();
		for (Specialization specialization : Specialization.values()) {
			specializations.put(specialization.toString(), (specialization.toString()));
		}

		return specializations;
	}
   /**
    * here we are implementing saveAppointment().
    * @param appointment
    */
	@Override
	public Appointment saveAppointment(Appointment appointment) {
		Patient patient = patientRepository.findPatientByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		Doctor doctor = doctorRepository.findDoctorById(appointment.getDoctor().getDoctorId());

		appointment.setPatient(patient);
		appointment.setDoctor(doctor);
		return appointmentRepository.save(appointment);
	}

	@Override
	public Appointment getAppointment(Long id) {
		return appointmentRepository.findById(id).get();
	}
	
	@Override
	public void cancelAppointment(Long id) {
		appointmentRepository.deleteById(id);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {

		return appointmentRepository.save(appointment);
	}

}
