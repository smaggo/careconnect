package com.samitamaggo.careconnect.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.samitamaggo.careconnect.entity.User;


public interface UserService extends UserDetailsService{
	User save(User registrationDto);
}
