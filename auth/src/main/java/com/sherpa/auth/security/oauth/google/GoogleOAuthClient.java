package com.sherpa.auth.security.oauth.google;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GoogleOAuthClient {

	private final RestTemplate restTemplate;

	@Value("${spring.security.oauth2.client.provider.google.token-uri}")
	private String tokenUri;

	@Value("${spring.security.oauth2.client.registration.google.client-id}")
	private String clientId;

	@Value("${spring.security.oauth2.client.registration.google.client-secret}")
	private String clientSecret;

	@Value("${spring.security.oauth2.client.registration.google.redirect-uri}")
	private String redirectUri;

	@Autowired
	public GoogleOAuthClient(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public GoogleTokenResponse exchangeCodeForToken(String code) {
		log.debug("Exchanging code for token: {}", code);
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("code", code);
		params.add("client_id", clientId);
		params.add("client_secret", clientSecret);
		params.add("redirect_uri", redirectUri);
		params.add("grant_type", "authorization_code");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
		ResponseEntity<GoogleTokenResponse> response = restTemplate.postForEntity(tokenUri, request,
			GoogleTokenResponse.class);

		System.out.println("exchange: response.getBody() = " + response.getBody());

		return response.getBody();
	}

}