package com.samitamaggo.careconnect.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.samitamaggo.careconnect.entity.Doctor;
import com.samitamaggo.careconnect.entity.Gender;
import com.samitamaggo.careconnect.entity.Patient;
import com.samitamaggo.careconnect.entity.Specialization;
import com.samitamaggo.careconnect.service.AppointmentService;
import com.samitamaggo.careconnect.service.DoctorService;

/**
 * Handles admin role requests and responses
 */
@Controller
public class AdminController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private AppointmentService appointmentService;

	public AdminController(DoctorService doctorService, AppointmentService appointmentService) {
		super();
		this.doctorService = doctorService;
		this.appointmentService = appointmentService;
	}
	
	/**
	 * <p>adminDashboard.</p>
	 * @param model
	 * @return
	 */

	@GetMapping("/admin")
	public String adminDashboard(Model model) {
		model.addAttribute("doctors", doctorService.getAll());
		return "admin/admin-home";
	}

	/**
	 * <p>addDoctorAcount.</p>
	 *
	 * @param newDoctor a {Doctor} object.
	 * @param model a {Model} object.
	 * @return a {String} object.
	 */
	@GetMapping("/admin/add-doctor")
	public String showAddDoctorPage(@ModelAttribute("doctor") Doctor doctor, Model model) {
		model.addAttribute("specEnums", Specialization.values());
		model.addAttribute("genderEnums", Gender.values());
		return "admin/add-doctor";
	}

	/**
	 * <p>saveDoctor.</p>
	 *
	 * @param newDoctor a {Doctor} object.
	 * @param bindingResult a {BindingResult} object.
	 * @param redirectAttributes a {RedirectAttributes} object.
	 * @return String object.
	 */
	@PostMapping("/admin/save-doctor")
	public String saveDoctor(@Valid @ModelAttribute("doctor") Doctor doctor, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		
		Doctor doc = doctorService.findDoctorByEmail(doctor.getUser().getEmail());

		if (doc != null) {
			return "redirect:/admin/add-doctor?alreadyexists";
		}

		try {
			doctorService.saveDoctor(doctor);
			redirectAttributes.addAttribute("specEnums", Specialization.values());
			redirectAttributes.addAttribute("genderEnums", Gender.values());
			redirectAttributes.addFlashAttribute("message", "Doctor successfully added!");
			return "redirect:/admin";
		}

		catch (Exception SQLIntegrityConstraintViolationException) {
			return "redirect:/admin/add-doctor?alreadyexists";

		}
	}

	/**
	 * <p>modifyAdminAccount.</p>
	 *
	 * @param doctorId a int.
	 * @param model a {Model} object.
	 * @return String object.
	 */
	@GetMapping("/admin/doctor/{doctorId}")
	public String modifyAdminAccount(@PathVariable Long doctorId, Model model) {

		Doctor doctor = doctorService.findDoctorById(doctorId);
		model.addAttribute("doctor", doctor);
		model.addAttribute("specializations", appointmentService.getAllSpecialization());

		return "admin/admin-doctor-account";
	}
}
