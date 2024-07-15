package com.sherpa.interview.domain.auth.oauth.google;

import org.springframework.stereotype.Service;

import com.sherpa.interview.domain.auth.oauth.OAuthService;
import com.sherpa.interview.domain.auth.oauth.constant.OAuthProviderEnum;

@Service
public class GoogleOAuthService implements OAuthService {

	private final GoogleOAuthClient googleOAuthClient;

	public GoogleOAuthService(GoogleOAuthClient googleOAuthClient) {
		this.googleOAuthClient = googleOAuthClient;
	}

	@Override
	public void login(String code) {
		var response = googleOAuthClient.exchangeCodeForToken(code);
		System.out.println("response.toString() = " + response.toString());
		System.out.println("code = " + code);
	}

	@Override
	public OAuthProviderEnum getProvider() {
		return OAuthProviderEnum.GOOGLE;
	}

}
