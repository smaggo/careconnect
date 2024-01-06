package com.samitamaggo.careconnect.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.samitamaggo.careconnect.entity.Patient;
import com.samitamaggo.careconnect.repository.PatientRepository;
/**
 * This is Test class for Patientservice
 */
@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

	@Mock
	private PatientRepository patientRepository;
	
	@InjectMocks
    private PatientServiceImpl patientServiceImpl;

	@Test
    void getPatientFound() {
		
		Long appId = (long) 1;
		Optional<Patient> app = patientRepository.findById(appId);
		
		assertThat(app).isNotNull();
       
    }
	
	@Test
    void getPatientNotFound() {
		
		Long appId = (long) 100;
		Optional<Patient> app = patientRepository.findById(appId);
		
		assertThat(app).isEmpty();
       
    }
	
	
}
