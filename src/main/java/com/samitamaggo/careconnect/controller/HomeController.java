package com.samitamaggo.careconnect.controller;

import org.springframework.stereotype.Controller;

/**
 * Handles Home page requests and responses
 */
@Controller
public class HomeController {
	
	
	public String viewHomePage() {
		return "home";
	}
	
}

