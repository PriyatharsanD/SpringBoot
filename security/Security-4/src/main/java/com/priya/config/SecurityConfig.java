package com.priya.config;

import org.apache.catalina.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain custorFilterChain(HttpSecurity http) throws Exception
	{
		return http
			.csrf(Customizer->Customizer.disable())
			.authorizeHttpRequests(request->request.anyRequest().authenticated())
			//.formLogin(Customizer.withDefaults())
			.httpBasic(Customizer.withDefaults())
			.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		    .build();
	}
	

}
