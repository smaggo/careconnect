package com.samitamaggo.careconnect.service;


import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.samitamaggo.careconnect.entity.Authority;
import com.samitamaggo.careconnect.entity.AuthorityRole;
import com.samitamaggo.careconnect.entity.User;
import com.samitamaggo.careconnect.repository.UserRepository;
/**
 * This class implements the UserService interface and provides the actual service(s) for a User object. 

 */

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
 /**
  * this save method saving the User and Setting authority to Role_Patient
  */
	@Override
	public User save(User user) {
		Authority authority = new Authority();
		authority.setAuthorityRole(AuthorityRole.ROLE_PATIENT);
		user.getAuthorities().add(authority);
		
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		return userRepository.save(user);
	}
	
     /**
      * Uses the userRepository to find the User by email.
      * This service will return the user details in the UserDetails object.
      *If the user object is null - (email was not found) it throws a UserNameNotFoundException.
       */
      
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapAuthoritiesToGrantedAuthorities(user.getAuthorities()));		
	}
	
	private Collection<? extends GrantedAuthority> mapAuthoritiesToGrantedAuthorities(Collection<Authority> authorities){
		return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthorityRole().toString())).collect(Collectors.toList());
	}
	
}