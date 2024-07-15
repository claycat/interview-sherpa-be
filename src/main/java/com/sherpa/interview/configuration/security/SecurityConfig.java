package com.sherpa.interview.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http,
		ClientRegistrationRepository clientRegistrationRepository) throws Exception {
		http
			.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
			.oauth2Login(oauth2Login -> oauth2Login.clientRegistrationRepository(clientRegistrationRepository));
		return http.build();
	}
}