package com.samitamaggo.careconnect.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.samitamaggo.careconnect.entity.User;
import com.samitamaggo.careconnect.repository.UserRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void listUsers() {
	
		List<User> users = userRepository.findAll();
		assertThat(users.size()).isGreaterThan(0);
	}

	@Test
	public void findUserByIdFound() {
	
		Long userId = (long) 1;
		Optional<User> user = userRepository.findById(userId);
		assertThat(user).isNotEmpty();
	}
	
	@Test
	public void findUserByIdNotFound() {
	
		Long userId = (long) 20;
		Optional<User> user = userRepository.findById(userId);
		assertThat(user).isEmpty();
	}
	
	@Test
	public void findUserByEmailFound() {
	
		String email = "patient@gmail.com";
		User user = userRepository.findByEmail(email);
		assertThat(user).isNotNull();
	}
	
	@Test
	public void findUserByEmailNotFound() {
	
		String email = "pp@gmail.com";
		User user = userRepository.findByEmail(email);
		assertThat(user).isNull();
	}
}
