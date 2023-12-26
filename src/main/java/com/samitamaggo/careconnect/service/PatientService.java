package com.samitamaggo.careconnect.service;

import com.samitamaggo.careconnect.entity.Patient;


public interface PatientService{

	Patient save(Patient patient);
	Patient findPatientByEmail(String email);
}
