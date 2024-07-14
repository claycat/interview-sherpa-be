package com.sherpa.interview.domain.auth.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sherpa.interview.domain.auth.oauth.constant.OAuthProviderEnum;
import com.sherpa.interview.domain.auth.oauth.urlgenerator.OAuthRequestUrlGeneratorResolver;

@Service
public class OAuthService {

	private final OAuthRequestUrlGeneratorResolver oAuthRequestUrlGeneratorResolver;

	@Autowired
	OAuthService(OAuthRequestUrlGeneratorResolver oAuthRequestUrlGeneratorResolver) {
		this.oAuthRequestUrlGeneratorResolver = oAuthRequestUrlGeneratorResolver;
	}

	public String getAuthCodeRequestUrl(OAuthProviderEnum oAuthProviderEnum) {
		return oAuthRequestUrlGeneratorResolver.getRequestUrlGenerator(oAuthProviderEnum).generate();
	}

}
