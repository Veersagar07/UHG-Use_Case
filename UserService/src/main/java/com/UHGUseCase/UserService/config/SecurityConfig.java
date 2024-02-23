package com.UHGUseCase.UserService.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.csrf(csrf -> csrf.disable())
	            .authorizeHttpRequests(authorizeRequests->authorizeRequests
	                    .requestMatchers("/users/signup","/users/signin","/users/update","users/findByUser", "/users/finduser").permitAll()
	                    .requestMatchers("/**").authenticated()
	                    )
	            .sessionManagement(sessionManagement ->
	                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            );
	 
	        // http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	 
	return http.build();
	    }
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManger(AuthenticationConfiguration authenticationConfiguration)throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}