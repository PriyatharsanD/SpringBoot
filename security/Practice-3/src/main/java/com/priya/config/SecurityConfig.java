package com.priya.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.priya.model.JwtFilter;
import com.priya.service.MyUserDetailsService;

@Configuration
public class SecurityConfig {

	@Autowired
	private MyUserDetailsService detailsService;

	@Autowired
	JwtFilter jwtFilter;

	@Bean
	public PasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		return http.csrf(customizer -> customizer.disable())
//				.authorizeHttpRequests(customizer -> customizer.requestMatchers("/login", "/register").permitAll()
//						.anyRequest().authenticated())
//				.httpBasic(Customizer.withDefaults())
//				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
		return http.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/register","/login")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authenticationProvider(authProvider())
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class).build();
	}

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provide = new DaoAuthenticationProvider();
		provide.setPasswordEncoder(pwdEncoder());
		provide.setUserDetailsService(detailsService);
		return provide;
	}

	@Bean
	public AuthenticationManager manager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

}
