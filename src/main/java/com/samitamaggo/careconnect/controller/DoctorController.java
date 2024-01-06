package com.samitamaggo.careconnect.controller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.samitamaggo.careconnect.entity.Doctor;
import com.samitamaggo.careconnect.service.DoctorService;

/**
 * Handles Doctor requests and responses
 */
@Controller
public class DoctorController {

	private DoctorService doctorService;
	
	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
	/**
	 * <p>showDoctorHome.</p>
	 * @param model,Doctor,Principal
	 * @return String object.
	 */
	
	@GetMapping("/doctors/home")
	public String showDoctorHome(@ModelAttribute("doctor") Doctor doctor, Model model, Principal principal) {
		Doctor foundDoctor = doctorService.findDoctorByEmail(principal.getName());
		model.addAttribute("appointments", foundDoctor.getAppointmentList());
		model.addAttribute("doctor", foundDoctor);
		return "doctors/doctor-home";
	}
	/**
	 * <p>deleteDoctor.</p>
	 * @param id
	 * @return String object.
	 */
	
	@GetMapping("/doctors/delete/{id}")
	public String deleteDoctor(@PathVariable (value = "id") long id) {
		// call delete appointment method 
		doctorService.deleteDoctor(id);
		return "redirect:/admin";
	}
}