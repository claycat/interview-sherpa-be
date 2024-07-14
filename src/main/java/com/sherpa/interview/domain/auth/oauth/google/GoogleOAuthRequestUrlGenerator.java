package com.sherpa.interview.domain.auth.oauth.google;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.sherpa.interview.domain.auth.oauth.constant.OAuthProviderEnum;
import com.sherpa.interview.domain.auth.oauth.urlgenerator.OAuthRequestUrlGenerator;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GoogleOAuthRequestUrlGenerator implements OAuthRequestUrlGenerator {

	private final GoogleOAuthMetadata googleOAuthConfig;

	public OAuthProviderEnum getProvider() {
		return OAuthProviderEnum.GOOGLE;
	}

	public String generate() {
		return UriComponentsBuilder
			.fromUriString("https://accounts.google.com/o/oauth2/v2/auth")
			.queryParam("response_type", "code")
			.queryParam("client_id", googleOAuthConfig.clientId())
			.queryParam("redirect_uri", googleOAuthConfig.redirectUri())
			.queryParam("scope", String.join(" ", googleOAuthConfig.scope()))
			.toUriString();
	}

}
