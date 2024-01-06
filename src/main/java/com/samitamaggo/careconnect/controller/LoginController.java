package com.samitamaggo.careconnect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.samitamaggo.careconnect.entity.AuthorityRole;
import com.samitamaggo.careconnect.entity.User;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Handles Login requests and responses
 */
@Controller
public class LoginController {
	/**
	 * <p>showLoginForm.</p>
	 * @param User,HttpServletRequest
	 * @return String object.
	 */
	@GetMapping({"/", "/home"})
	public String showLoginForm(@ModelAttribute("user") User user, HttpServletRequest request) {
		String path = redirectByRole(request);
		
		if ("".equals(path)) {
			return "home";
		}

		return path;
	}
	/**
	 * <p>loginSuccess.</p>
	 * @param HttpservletRequest
	 * @return String object.
	 */
	
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
		/**
		 * <p>loginFailed.</p>
		 * @param model,user
		 * @return String object.
		 */
		
		@GetMapping("/login-failed")
		public String loginFailed(@ModelAttribute("user") User user, Model model) {
			model.addAttribute("fail", true);
			return "home";
		}
		/**
		 * <p>logout.</p>
		 * @param model
		 * @return String object.
		 */
	
		@GetMapping("/logout")
		public String logout(Model model) {
			return "redirect:/home";
		}

		/**
		 * <p>error.</p>
		 * @param model
		 * @return String object.
		 */
		@GetMapping("/403")
		public String error(Model model) {
			return "403";
		}
}



