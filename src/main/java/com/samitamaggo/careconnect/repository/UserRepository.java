package com.samitamaggo.careconnect.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samitamaggo.careconnect.entity.User;

/**
 * UserRepository extends JpaRepository with basic CRUd operations.
 * Also include custom method findByEmail
 * @param email
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}