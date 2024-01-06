package com.samitamaggo.careconnect.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.samitamaggo.careconnect.entity.Authority;
import com.samitamaggo.careconnect.entity.AuthorityRole;
import com.samitamaggo.careconnect.entity.Doctor;
import com.samitamaggo.careconnect.entity.Specialization;
import com.samitamaggo.careconnect.repository.DoctorRepository;

import jakarta.transaction.Transactional;

/**
 * /**
 * This class implements the doctorService interface and provides the actual service(s) for Doctor object. 

 */
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/**  
	 * It implementing saveDoctor() from DoctorService interface
	 */
	@Override
	public void saveDoctor(Doctor doctor) {
		Authority authority = new Authority();
		authority.setAuthorityRole(AuthorityRole.ROLE_DOCTOR);
		doctor.getUser().getAuthorities().add(authority);
		
		String encodedPassword = passwordEncoder.encode(doctor.getUser().getPassword());
		doctor.getUser().setPassword(encodedPassword);

		doctorRepository.save(doctor);
	}
	/**{@inheritDoc}*/
	@Override
	public void deleteDoctor(Long id) {
		doctorRepository.deleteById(id);
	}

	/** {@inheritDoc} */
	@Override
	public void updateDoctor(Doctor doctor) {
		Doctor doctorUpdate = doctorRepository.findDoctorById(doctor.getDoctorId());

		doctorUpdate.setFirstName(doctor.getFirstName());
		doctorUpdate.setLastName(doctor.getLastName());
		doctorUpdate.setDateOfBirth(doctor.getDateOfBirth());
		doctorUpdate.setGender(doctor.getGender());
		doctorUpdate.setSpecialization(doctor.getSpecialization());

		doctorUpdate.getUser().setEmail(doctor.getUser().getEmail());

		if (!doctor.getUser().getPassword().isEmpty()) {
			String encodedPassword = passwordEncoder.encode(doctor.getUser().getPassword());
			doctorUpdate.getUser().setPassword(encodedPassword);
		}

		doctorRepository.save(doctorUpdate);
	}

	/** {@inheritDoc} */
	@Override
	public List<Doctor> getAll() {
		List<Doctor> doctors = new ArrayList<Doctor>();

		for (Doctor d : doctorRepository.findAll()) {
			doctors.add(d);
		}

		return doctors;
	}

	/** {@inheritDoc} */
	public Doctor findDoctorById(Long id) {
		Doctor doctor = doctorRepository.findDoctorById(id);
		return doctor;
	}

	/** {@inheritDoc} */
	@Override
	public Map<Long, String> findDoctorBySpecialization(Specialization spec) {
		List<Doctor> doctors = doctorRepository.findDoctorBySpecialization(spec);

		if (doctors.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Long, String> doctorMap = new HashMap<>();
		for (Doctor doctor : doctors) {
			doctorMap.put(doctor.getDoctorId(), doctor.getFullName());
		}

		return doctorMap;
	}

	/** {@inheritDoc} */
	@Override
	public Doctor findDoctorByEmail(String email) {
		return doctorRepository.findDoctorByEmail(email);
	}


	
}
