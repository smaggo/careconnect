package com.samitamaggo.careconnect.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.samitamaggo.careconnect.entity.Appointment;
import com.samitamaggo.careconnect.repository.AppointmentRepository;

/**
 * This is Test class for AppointmentService
 */
@ExtendWith(MockitoExtension.class)
public class AppointmentServiceTest {

	@Mock
	private AppointmentRepository appointmentRepository;
	
	@InjectMocks
    private AppointmentServiceImpl appointmentServiceImpl;

	/**
	 * testing getAppointmentFound()
	 */
	@Test
    void getAppointmentFound() {
		
		Long appId = (long) 8;
		Optional<Appointment> app = appointmentRepository.findById(appId);
		
		assertThat(app).isNotNull();
       
    }
	/**
	 * testing getAppointmentNotFound()
	 */
	
	@Test
    void getAppointmentNotFound() {
		
		Long appId = (long) 100;
		Optional<Appointment> app = appointmentRepository.findById(appId);
		
		assertThat(app).isEmpty();
       
    }
	
	
}
