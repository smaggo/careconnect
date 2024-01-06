package com.samitamaggo.careconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.samitamaggo.careconnect.entity.Appointment;
import com.samitamaggo.careconnect.entity.AppointmentStatus;
import com.samitamaggo.careconnect.entity.AuthorityRole;
import com.samitamaggo.careconnect.service.AppointmentService;
import com.samitamaggo.careconnect.service.DoctorService;
import jakarta.servlet.http.HttpServletRequest;


/**
 * Handles appointment requests and responses
 */
@Controller
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private DoctorService doctorService;
	
	
	@GetMapping("/appointments/register")
	public String showRegistrationAppointment(@ModelAttribute("appointment") Appointment appointment, Model model) {
		appointment.getDoctor().setSpecialization(null);
		model.addAttribute("doctors", doctorService.getAll());
		model.addAttribute("specializations", appointmentService.getAllSpecialization());
		return "appointments/appointment-create";
	}
	
	
	@PostMapping("/appointments")
	public String saveAppointment(@ModelAttribute("appointment") Appointment appointment, Model model) {
		// save appointment to database
		appointmentService.saveAppointment(appointment);
		return "redirect:/patients/home";
	}
	
	
	@GetMapping("/appointments/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get appointment from the service
		Appointment appointment = appointmentService.getAppointment(id);
		
		// set appointment as a model attribute to pre-populate the form
		model.addAttribute("appointment", appointment);
		model.addAttribute("doctors", doctorService.getAll());

		return "/appointments/appointment-update";
	}
	
	@GetMapping("/appointments/accept/{id}")
	public String acceptAppointment(@PathVariable ( value = "id") long id, Model model) {
		Appointment appointment = appointmentService.getAppointment(id);

		appointment.setStatus(AppointmentStatus.ACCEPTED);
		appointmentService.updateAppointment(appointment);
		
		return "redirect:/doctors/home";
	}
	
	@GetMapping("/appointments/reject/{id}")
	public String rejectAppointment(@PathVariable ( value = "id") long id, Model model) {
		Appointment appointment = appointmentService.getAppointment(id);

		appointment.setStatus(AppointmentStatus.REJECTED);
		appointmentService.updateAppointment(appointment);
		
		return "redirect:/doctors/home";
	}
	
	@GetMapping("/appointments/deleteAppointment/{id}")
	public String deleteAppointment(@PathVariable (value = "id") long id) {
		// call delete appointment method 
		appointmentService.cancelAppointment(id);
		return "redirect:/patients/home";
	}
	
	@GetMapping("/appointments/{id}/detail")
	public String getAppointmentDetail(@ModelAttribute("appointment") Appointment appointment,
			@PathVariable(value ="id") long id, Model model, HttpServletRequest request) {

		appointment = appointmentService.getAppointment(id);
		model.addAttribute("appointment", appointment);

		if (request.isUserInRole(AuthorityRole.ROLE_PATIENT.toString())) {
			return "appointment-detail";
		} else {
			return "doctor-appointment-detail";
		}
	}
	
}