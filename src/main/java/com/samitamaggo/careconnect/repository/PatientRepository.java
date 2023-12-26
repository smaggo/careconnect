package com.samitamaggo.careconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.samitamaggo.careconnect.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

	@Query("SELECT p FROM Patient p INNER JOIN p.user u WHERE u.email = :email")
	Patient findPatientByEmail(@Param(value = "email") String email);
}
