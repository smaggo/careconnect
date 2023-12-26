package com.samitamaggo.careconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samitamaggo.careconnect.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
