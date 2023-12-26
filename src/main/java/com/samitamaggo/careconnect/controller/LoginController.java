package com.samitamaggo.careconnect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.samitamaggo.careconnect.entity.AuthorityRole;
import com.samitamaggo.careconnect.entity.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	@GetMapping({"/", "/home"})
	public String showLoginForm(@ModelAttribute("user") User user, HttpServletRequest request) {
		String path = redirectByRole(request);
		
		if ("".equals(path)) {
			return "home";
		}

		return path;
	}
	
	@GetMapping("/login-success")
	public String loginSuccess(HttpServletRequest request) {
		String path = redirectByRole(request);

		if ("".equals(path)) {
			return "redirect:/home";
		}

		return path;
	}

		private String redirectByRole(HttpServletRequest request) {
		if (request.isUserInRole(AuthorityRole.ROLE_PATIENT.toString())) {
			return "redirect:/patients/home";
		}

		if (request.isUserInRole(AuthorityRole.ROLE_DOCTOR.toString())) {
			return "redirect:/doctors/home";
		}

		if (request.isUserInRole(AuthorityRole.ROLE_ADMIN.toString())) {
			return "redirect:/admin";
		}

		return "";
	}
		
		@GetMapping("/login-failed")
		public String loginFailed(@ModelAttribute("user") User user, Model model) {
			model.addAttribute("fail", true);
			return "home";
		}
		
	
		@GetMapping("/logout")
		public String logout(Model model) {
			return "redirect:/home";
		}

		
		@GetMapping("/403")
		public String error(Model model) {
			return "403";
		}
}



