package com.samitamaggo.careconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samitamaggo.careconnect.entity.Appointment;

/**
 * AppointmentRepository extend JpaRepository that contain all basic CRUD operations
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
