package com.sherpa.auth.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sherpa.auth.security.jwt.AccessTokenPayload;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private final SecretKey secretKey;

	@Value("${spring.application.name")
	private String issuer;

	@Value("${jwt.access-key-expiration-ms}")
	private long accessKeyExpirationInMs;

	public JwtService(@Value("${jwt.secret-key}") String secretKey) {
		this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
	}

	public String createAccessToken(AccessTokenPayload jwtPayload) {

		return Jwts.builder()
			.subject(jwtPayload.email())
			.issuer(issuer)
			.issuedAt(jwtPayload.issuedAt())
			.expiration(new Date(jwtPayload.issuedAt().getTime() + accessKeyExpirationInMs))
			.signWith(secretKey)
			.compact();
	}

}
