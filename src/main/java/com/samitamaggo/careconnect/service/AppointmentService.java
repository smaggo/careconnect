package com.samitamaggo.careconnect.service;

import java.util.Map;
import com.samitamaggo.careconnect.entity.Appointment;


public interface AppointmentService {

	/**
	 * <p>getAllSpecialization.</p>
	 *
	 * @return a {@link java.util.Map} object.
	 */
	Map<String, String> getAllSpecialization();


	Appointment saveAppointment(Appointment appointment);

	

	Appointment getAppointment(Long id);


	void cancelAppointment(Long id);


	Appointment updateAppointment(Appointment appointment);


}