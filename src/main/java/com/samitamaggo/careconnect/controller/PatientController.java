package com.samitamaggo.careconnect.controller;

import java.security.Principal;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.samitamaggo.careconnect.entity.Gender;
import com.samitamaggo.careconnect.entity.Patient;
import com.samitamaggo.careconnect.service.PatientService;

/**
 * Handles Patient requests and response
 */
@Controller
public class PatientController {

	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	/**
	 * <p>
	 * showRegistrationForm.
	 * </p>
	 * 
	 * @param model,patient
	 * @return String object.
	 */

	@GetMapping("/patients/register")
	public String showRegistrationForm(@ModelAttribute("patient") Patient patient, Model model) {
		model.addAttribute("genderEnums", Gender.values());
		return "patients/patient-register";
	}

	/**
	 * <p>
	 * registerPatient.
	 * </p>
	 * 
	 * @param patient,redirectattributes
	 * @return String object.
	 */

	@PostMapping("/patients")
	public String registerPatient(@ModelAttribute("patient") Patient patient, RedirectAttributes redirectAttributes) {
		Patient pat = patientService.findPatientByEmail(patient.getUser().getEmail());
		if (pat != null) {
			return "redirect:/home?alreadyexists";
		}

		try {
			patientService.save(patient);
			redirectAttributes.addFlashAttribute("patient", patient);
			return "redirect:/patients/successful";
		}

		catch (final DuplicateKeyException e) {
			return "redirect:/home?alreadyexists";

		}

	}

	/**
	 * <p>
	 * showRegistrationSuccessful.
	 * </p>
	 * 
	 * @param patient
	 * @return String object.
	 */
	@GetMapping("/patients/successful")
	public String showRegistrationSuccessful(@ModelAttribute("patient") Patient patient) {
		return "patients/patient-register-successful";
	}

	/**
	 * <p>
	 * showPatientHome.
	 * </p>
	 * 
	 * @param patient,model,principal
	 * @return String object.
	 */

	@GetMapping("/patients/home")
	public String showPatientHome(@ModelAttribute("patient") Patient patient, Model model, Principal principal) {
		Patient foundPatient = patientService.findPatientByEmail(principal.getName());
		model.addAttribute("appointments", foundPatient.getAppointmentList());
		return "patients/patient-home";
	}
}
