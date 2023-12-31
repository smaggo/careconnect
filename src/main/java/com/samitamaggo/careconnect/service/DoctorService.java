package com.samitamaggo.careconnect.service;

import java.util.List;
import java.util.Map;

import com.samitamaggo.careconnect.entity.Doctor;
import com.samitamaggo.careconnect.entity.Specialization;

/**
 * This interface provide services to Doctor object
 */

public interface DoctorService {

	/**
	 * <p>saveDoctor.</p>
	 *
	 * @param doctor a Doctor object.
	 */
	public void saveDoctor(Doctor doctor);
	/**
	 * <p>deleteDoctor.</p>
	 * @param id
	 */
	public void deleteDoctor(Long id);

	/**
	 * <p>updateDoctor.</p>
	 *
	 * @param doctor a Doctor object.
	 */
	public void updateDoctor(Doctor doctor);

	/**
	 * <p>getAll.</p>
	 *
	 * @return a list of doctors
	 */
	public List<Doctor> getAll();

	/**
	 * <p>findDoctorById.</p>
	 *
	 * @param id a int.
	 * @return Doctor
	 */
	public Doctor findDoctorById(Long id);

	/**
	 * <p>findDoctorBySpecialization.</p>
	 *
	 * @param specialization a Specialization object.
	 * @return a {@link java.util.Map} object.
	 */
	public Map<Long, String> findDoctorBySpecialization(Specialization specialization);

	/**
	 * <p>findDoctorByEmail.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @return a {@link mum.waa.fd.app.domain.Doctor} object.
	 */
	public Doctor findDoctorByEmail(String name);
}

