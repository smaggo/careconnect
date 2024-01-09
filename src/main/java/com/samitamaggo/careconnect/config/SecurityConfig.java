package com.samitamaggo.careconnect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


/**
 * Security Configuration Class
 * It will load User information during authentication and set request authorization (what endpoints - pages a User has access to once authenticated)
*/

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        
		
		          
		http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> authorize
                		.requestMatchers("/**").permitAll()
                		.requestMatchers("/patients/home**").hasRole("PATIENT")
                		.requestMatchers("/admin/**").hasRole("ADMIN")
                		.requestMatchers("/doctors/home**").hasRole("DOCTOR")
                		.requestMatchers("/appointments/**").hasAnyRole("DOCTOR", "PATIENT")
                        );
                                
         
                http.formLogin(
                        form -> form
                                .loginPage("/home")
                                .loginProcessingUrl("/doLogin")
                                .usernameParameter("email")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/login-success")
                                .failureUrl("/home?loginerror")
                                .permitAll()
                );
                
                http.logout(
                logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/home")
                        .invalidateHttpSession(true)
                		.clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll());
                        

                http.sessionManagement(session -> session
                		.invalidSessionUrl("/home?expired")
                    
                     
                        );
                
                return http.build();
	}
		
	
}
