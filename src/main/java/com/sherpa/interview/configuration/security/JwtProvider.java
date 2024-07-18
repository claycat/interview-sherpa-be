package com.sherpa.interview.configuration.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

public class JwtProvider {

	private String secretKey = "your_secret_key"; // Ensure this is secured and not hard-coded in production

	public String createToken(Authentication authentication) {
		User principal = (User) authentication.getPrincipal();
		return Jwts.builder()
			.setSubject(principal.getUsername())
			.claim("authorities", principal.getAuthorities())
			.signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
			.compact();
	}
}
