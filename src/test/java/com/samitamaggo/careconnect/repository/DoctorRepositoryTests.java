package com.samitamaggo.careconnect.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.samitamaggo.careconnect.entity.Authority;
import com.samitamaggo.careconnect.entity.AuthorityRole;
import com.samitamaggo.careconnect.entity.Doctor;
import com.samitamaggo.careconnect.entity.Gender;
import com.samitamaggo.careconnect.entity.Patient;
import com.samitamaggo.careconnect.entity.Specialization;
import com.samitamaggo.careconnect.entity.User;
import com.samitamaggo.careconnect.repository.DoctorRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DoctorRepositoryTests {
	
	@Autowired
    private DoctorRepository docRepository;
	
	@Test
	//JUnit test for findDoctorBySpecialization
	public void docSpecFound() {
		
		Specialization spec = Specialization.CARDIOLOGIST;
		List<Doctor> doctors = docRepository.findDoctorBySpecialization(spec);
		
		assertThat(doctors.size()).isGreaterThan(0);
		
	}
	
	@Test
	//JUnit test for findDoctorBySpecialization
	public void docSpecNotFound() {
		
		Specialization spec = Specialization.HEPATOLOGIST;
		List<Doctor> doctors = docRepository.findDoctorBySpecialization(spec);
		
		assertThat(doctors).isEmpty();
		
	}
	
	@Test
	//JUnit test for findDoctorById Found
	public void docIdFound() {
		
		Long id = (long) 3;
		Doctor doctor = docRepository.findDoctorById(id);
		
		assertThat(doctor).isNotNull();
		
	}
	
	@Test
	//JUnit test for findDoctorById Not Found
	public void docIdNotFound() {
		
		Long id = (long) 1;
		Doctor doctor = docRepository.findDoctorById(id);
		
		assertThat(doctor).isNull();

		
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"john@gmail.com"})
	//JUnit test for findDoctorByEmail
	public void docEmailFound(String email) {
		Doctor doctor = docRepository.findDoctorByEmail(email);
		
		assertThat(doctor).isNotNull();
		
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"No@doc.com"})
	//JUnit test for findDoctorByEmail
	public void docEmailNotFound(String email) {
		
		Doctor doctor = docRepository.findDoctorByEmail(email);
		
		assertThat(doctor).isNull();
		
	}

}
