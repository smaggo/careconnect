package com.samitamaggo.careconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.samitamaggo.careconnect.entity.Authority;
import com.samitamaggo.careconnect.entity.AuthorityRole;
import com.samitamaggo.careconnect.entity.Patient;
import com.samitamaggo.careconnect.repository.PatientRepository;
/**
 * This class implements the PatientService interface and provides the actual service(s) for a Patient object. 
*/

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository patientRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}
    /**
     * Here it implementing save patient method from PatientService interface
     */
	@Override
	public Patient save(Patient patient) {
		
		Authority authority = new Authority();
		authority.setAuthorityRole(AuthorityRole.ROLE_PATIENT);
		patient.getUser().getAuthorities().add(authority);

		String encodedPassword = passwordEncoder.encode(patient.getUser().getPassword());
		patient.getUser().setPassword(encodedPassword);

		return patientRepository.save(patient);

	}
	
	/**
	 * Here it implementing findPatientByemail from PatientService interface
	 */

	@Override
	public Patient findPatientByEmail(String email) {
		
		return patientRepository.findPatientByEmail(email);
		
		
	}

	

}
