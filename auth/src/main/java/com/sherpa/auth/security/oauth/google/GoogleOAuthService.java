package com.sherpa.auth.security.oauth.google;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Service;

import com.sherpa.auth.constant.OAuthProviderEnum;
import com.sherpa.auth.security.oauth.OAuthService;

@Service
public class GoogleOAuthService implements OAuthService {

	private final GoogleOAuthClient googleOAuthClient;


	@Autowired
	private OAuth2AuthorizedClientService auth2AuthorizedClientService;

	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;

	public GoogleOAuthService(GoogleOAuthClient googleOAuthClient) {
		this.googleOAuthClient = googleOAuthClient;
	}

	@Override
	public void login(String code) {
		var response = googleOAuthClient.exchangeCodeForToken(code);
	}

	@Override
	public OAuthProviderEnum getProvider() {
		return OAuthProviderEnum.GOOGLE;
	}

}