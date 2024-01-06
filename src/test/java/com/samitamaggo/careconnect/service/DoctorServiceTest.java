package com.samitamaggo.careconnect.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.samitamaggo.careconnect.entity.Doctor;
import com.samitamaggo.careconnect.repository.DoctorRepository;
/**
 * This is test class DoctorService
 */
@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

	@Mock
	private DoctorRepository doctorRepository;
	
	@InjectMocks
    private DoctorServiceImpl doctorServiceImpl;

	@Test
    void getDoctorFound() {
		
		Long appId = (long) 3;
		Optional<Doctor> app = doctorRepository.findById(appId);
		
		assertThat(app).isNotNull();
       
    }
	
	@Test
    void getDoctorNotFound() {
		
		Long appId = (long) 100;
		Optional<Doctor> app = doctorRepository.findById(appId);
		
		assertThat(app).isEmpty();
       
    }
	
	
}
