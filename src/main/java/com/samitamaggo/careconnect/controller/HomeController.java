package com.samitamaggo.careconnect.controller;

import org.springframework.stereotype.Controller;

/**
 * Handles Home page requests and responses
 */
@Controller
public class HomeController {
	
	/**
	 * <p>rejectAppointment.</p>
	*@return String
	**/
	 
	public String viewHomePage() {
		return "home";
	}
	
}

