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

import com.samitamaggo.careconnect.entity.Gender;
import com.samitamaggo.careconnect.entity.Patient;
import com.samitamaggo.careconnect.entity.User;
import com.samitamaggo.careconnect.entity.Authority;
import com.samitamaggo.careconnect.entity.AuthorityRole;
import com.samitamaggo.careconnect.repository.PatientRepository;
/**
 * Test class for PatientRepository
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PatientRepositoryTests {
	
	@Autowired
    private PatientRepository patientRepository;
	
	@ParameterizedTest
	@ValueSource(strings = {"gabriel@gmail.com"})
	//JUnit test for findPatientByEmail
	public void patientFound(String email) {
		
		Patient patient = patientRepository.findPatientByEmail(email);
		
		assertThat(patient.getUser().getEmail()).isEqualTo(email);
		
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"pp@gmail.com"})
	//JUnit test for patientNotFound
	public void patientNotFound(String email) {
		
		Patient patient = patientRepository.findPatientByEmail(email);
		
		assertThat(patient).isNull();
		
	}
	
	@Test
	//JUnit test for register Patient
	public void patientRegister() {
		
		Patient patient = new Patient();
		Calendar cal = Calendar.getInstance();
		Date dateOfBirth = cal.getTime();
		
		patient.setDateOfBirth(dateOfBirth);
		patient.setFirstName("TestFName");
		patient.setLastName("TestLName");
		patient.setGender(Gender.MALE);
		patient.setPhone("667-000-0000");
		
		User user  = new User();
		List<Authority> authorities = new ArrayList<Authority>();
		Authority auth = new Authority();
		auth.setAuthorityRole(AuthorityRole.ROLE_PATIENT);
		authorities.add(auth);
		user.setAuthorities(authorities);
		
		user.setEmail("test@gmail.com");
		user.setPassword("pwd");
		
		patient.setUser(user);
		
		Patient patientSaved = patientRepository.save(patient);

		
		assertThat(patientSaved.getPatientId()).isGreaterThan(0);
		
	}
}
