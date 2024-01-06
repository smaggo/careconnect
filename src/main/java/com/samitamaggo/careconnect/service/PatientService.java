package com.samitamaggo.careconnect.service;

import com.samitamaggo.careconnect.entity.Patient;
/**
 * This interface provide services to Patient object
 */


public interface PatientService{
   /**
    * <p>save</P>
    * @param patient
    * @return
    */
	Patient save(Patient patient);
	/**
	 * <P>findPatientByEmail</p>
	 * @param email
	 * @return
	 */
	Patient findPatientByEmail(String email);
}
