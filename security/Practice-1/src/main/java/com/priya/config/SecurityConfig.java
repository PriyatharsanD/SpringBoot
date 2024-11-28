package com.priya.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.priya.Model.JwtFilter;
import com.priya.service.MyUserDetailsService;

import jakarta.servlet.Filter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	JwtFilter jwtFilter;
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		return http
				.csrf(customizer->customizer.disable())
				.authorizeHttpRequests(customizer->customizer
						.requestMatchers("login","register")
						.permitAll()
						.anyRequest()
						.authenticated())
				.httpBasic(Customizer.withDefaults())
				.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class)
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
	}
	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	@Bean
	public AuthenticationManager manager(AuthenticationConfiguration config) throws Exception
	{
		return config.getAuthenticationManager();
	}
}
