package com.samitamaggo.careconnect.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.samitamaggo.careconnect.entity.User;
/**
 * This interface provide services to User object
 */

public interface UserService extends UserDetailsService{
	/**
	 * <P>save</p>
	 * @param registrationDto
	 * @return
	 */
	User save(User registrationDto);
}
