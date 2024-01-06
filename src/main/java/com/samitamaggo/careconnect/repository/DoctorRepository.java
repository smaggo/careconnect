package com.samitamaggo.careconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.samitamaggo.careconnect.entity.Doctor;
import com.samitamaggo.careconnect.entity.Specialization;

/**
 * DoctorRepository extends JpaRepository with basic CRUd operations.
 * Also include custom methods findDoctorByspecialization , findDoctorByEmail , findDoctorById
 */

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	
	@Query("SELECT d FROM Doctor d WHERE d.specialization = :spec")
	List<Doctor> findDoctorBySpecialization(@Param(value = "spec") Specialization spec);

	@Query("SELECT d FROM Doctor d INNER JOIN d.user u WHERE u.email = :email")
	Doctor findDoctorByEmail(@Param(value = "email") String email);

	@Query("SELECT d FROM Doctor d INNER JOIN d.user u WHERE d.id = :doctorId")
	Doctor findDoctorById(@Param(value = "doctorId") Long doctorId);
}