package com.sherpa.auth.security.oauth.google;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GoogleOAuthClient {

	private HttpTransport httpTransport = new NetHttpTransport();
	private GsonFactory gsonFactory = GsonFactory.getDefaultInstance();

	@Value("${spring.security.oauth2.client.provider.google.token-uri}")
	private String tokenUri;

	@Value("${spring.security.oauth2.client.registration.google.client-id}")
	private String clientId;

	@Value("${spring.security.oauth2.client.registration.google.client-secret}")
	private String clientSecret;

	@Value("${spring.security.oauth2.client.registration.google.redirect-uri}")
	private String redirectUri;

	public GoogleTokenResponse exchangeCodeForToken(String code) throws IOException {

		GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(
			httpTransport,
			gsonFactory,
			tokenUri,
			clientId,
			clientSecret,
			code,
			redirectUri
		).execute();

		return tokenResponse;
	}

	public GoogleUserInfo extractGoogleUserInfo(GoogleTokenResponse tokenResponse) throws IOException {
		GoogleIdToken googleIdToken = tokenResponse.parseIdToken();
		GoogleIdToken.Payload payload = googleIdToken.getPayload();

		return GoogleUserInfo.builder()
			.email(payload.getEmail())
			.pictureUrl((String)payload.get("picture"))
			.name((String)payload.get("name"))
			.build();
	}

}