package com.sherpa.auth.security.oauth.google;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.sherpa.auth.constant.OAuthProviderEnum;
import com.sherpa.auth.security.oauth.OAuthService;

@Service
public class GoogleOAuthService implements OAuthService {

	private final GoogleOAuthClient googleOAuthClient;

	public GoogleOAuthService(GoogleOAuthClient googleOAuthClient) {
		this.googleOAuthClient = googleOAuthClient;
	}

	@Override
	public void login(String code) throws IOException {
		var response = googleOAuthClient.exchangeCodeForToken(code);
	}

	@Override
	public OAuthProviderEnum getProvider() {
		return OAuthProviderEnum.GOOGLE;
	}

}