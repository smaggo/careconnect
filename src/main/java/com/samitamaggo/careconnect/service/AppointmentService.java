package com.samitamaggo.careconnect.service;

import java.util.Map;
import com.samitamaggo.careconnect.entity.Appointment;

/**
 * This interface provide services to Map object
 */


public interface AppointmentService {

	/**
	 * <p>getAllSpecialization.</p>
	 *
	 * @return a {Map} object.
	 */
	Map<String, String> getAllSpecialization();

/**
 * <p>saveAppointment</p>
 * @param appointment
 * @return
 */
	Appointment saveAppointment(Appointment appointment);
   /**
    * <p> getAppointment.</p>
    * @param id
    * @return
    */
	

	Appointment getAppointment(Long id);
    /**
     * <p>cancelAppointment</P>
     * @param id
     */

	void cancelAppointment(Long id);
   /**
    * <p>updateAppointment</P>
    * @param appointment
    * @return
    */

	Appointment updateAppointment(Appointment appointment);


}