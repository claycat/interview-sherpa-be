package com.sherpa.interview.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.sherpa.interview.configuration.security.oauth.CustomAuthenticationSuccessHandler;

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
			.csrf(AbstractHttpConfigurer::disable)
			.sessionManagement(s->s.sessionCreationPolicy((SessionCreationPolicy.IF_REQUIRED)))
			.formLogin(AbstractHttpConfigurer::disable)
			.httpBasic(AbstractHttpConfigurer::disable)
			.authorizeRequests(authorizeRequests -> authorizeRequests
				.requestMatchers("/oauth/login/google").permitAll()
				.anyRequest().authenticated())
			.oauth2Login(oauth2Login -> oauth2Login
				.successHandler(new CustomAuthenticationSuccessHandler(jwtProvider()))
				.clientRegistrationRepository(clientRegistrationRepository));
		return http.build();
	}


	@Bean
	public JwtProvider jwtProvider() {
		return new JwtProvider();
	}

	@Bean
	public AuthenticationSuccessHandler successHandler() {
		SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
		handler.setRedirectStrategy(new DefaultRedirectStrategy());
		handler.setDefaultTargetUrl("/dashboard");
		return handler;
	}
}