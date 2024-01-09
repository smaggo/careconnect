package com.samitamaggo.careconnect.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.samitamaggo.careconnect.entity.Appointment;
import com.samitamaggo.careconnect.repository.AppointmentRepository;
/**
 * Test class for AppointmentRepository
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AppointmentRepositoryTests {
	
	@Autowired
	private AppointmentRepository appRepository;
	
	@Test
	public void listAppointments() {
	
		List<Appointment> apps = appRepository.findAll();
		assertThat(apps.size()).isGreaterThan(0);
	}

	@Test
	public void findAppointmentByIdFound() {
	
		Long appId = (long) 1;
		Optional<Appointment> app = appRepository.findById(appId);
		assertThat(app).isNotEmpty();
	}
	
	@Test
	public void findAppointmentByIdNotFound() {
	
		Long appId = (long) 100;
		Optional<Appointment> app = appRepository.findById(appId);
		assertThat(app).isEmpty();
	}
}
