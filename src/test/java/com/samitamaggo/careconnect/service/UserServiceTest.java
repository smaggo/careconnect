package com.samitamaggo.careconnect.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.samitamaggo.careconnect.entity.User;
import com.samitamaggo.careconnect.repository.UserRepository;
/**
 * This is test Class for Userservice
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
    private UserServiceImpl userServiceImpl;

	@Test
    void getUserFound() {
		
		Long appId = (long) 1;
		Optional<User> app = userRepository.findById(appId);
		
		assertThat(app).isNotNull();
       
    }
	
	@Test
    void getUserNotFound() {
		
		Long appId = (long) 100;
		Optional<User> app = userRepository.findById(appId);
		
		assertThat(app).isEmpty();
       
    }
	
	
}
