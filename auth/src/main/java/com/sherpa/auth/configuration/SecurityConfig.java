package com.sherpa.auth.configuration;


import org.apache.catalina.connector.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.sherpa.auth.security.JwtProvider;
import com.sherpa.auth.security.oauth.CustomAuthenticationSuccessHandler;
import com.sherpa.auth.security.oauth.OAuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService = new OidcUserService();
		http
			.csrf(AbstractHttpConfigurer::disable)
			.sessionManagement(s->s.sessionCreationPolicy((SessionCreationPolicy.IF_REQUIRED)))
			.formLogin(AbstractHttpConfigurer::disable)
			.httpBasic(AbstractHttpConfigurer::disable)
			.authorizeRequests(authorizeRequests -> authorizeRequests
				.requestMatchers("/oauth/login/google").permitAll()
				.anyRequest().authenticated())
			.oauth2Login(oauth2Login -> oauth2Login
				.successHandler(new CustomAuthenticationSuccessHandler(jwtProvider())));
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