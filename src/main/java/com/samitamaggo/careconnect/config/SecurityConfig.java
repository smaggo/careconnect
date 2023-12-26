package com.samitamaggo.careconnect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Autowired
//    private DataSource dataSource;

    
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//    auth.jdbcAuthentication().dataSource(dataSource)
//                .passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery("select email,password from user where email =?")
//                .authoritiesByUsernameQuery(" select u.email, a.authority from user u, authority a where u.email = a.email and u.email=?");
//    }
	
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
                
//                 .requestMatchers("/index").permitAll()
                
         
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
//                        .maximumSessions(1)
//                        .expiredUrl("/home?expired")
                        );
                
                return http.build();
	}
		
	
}
