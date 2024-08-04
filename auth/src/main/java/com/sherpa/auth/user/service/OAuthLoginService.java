package com.sherpa.auth.user.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.sherpa.auth.security.JwtService;
import com.sherpa.auth.security.jwt.AccessTokenPayload;
import com.sherpa.auth.user.dto.OAuthLoginCommand;
import com.sherpa.auth.user.dto.OAuthLoginResult;

@Service
public class OAuthLoginService {

	private final JwtService jwtService;

	public OAuthLoginService(JwtService jwtService) {
		this.jwtService = jwtService;
	}

	public OAuthLoginResult login(OAuthLoginCommand loginCommand) {

		var payload = AccessTokenPayload.builder()
			.email(loginCommand.getEmail())
			.issuedAt(new Date(System.currentTimeMillis()))
			.build();

		var accessToken = jwtService.createAccessToken(payload);

		return OAuthLoginResult.builder()
			.accessToken(accessToken)
			.build();

	}
}
