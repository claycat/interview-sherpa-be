package com.sherpa.interview.domain.auth.oauth;

import com.sherpa.interview.domain.auth.oauth.constant.OAuthProviderEnum;

public interface OAuthService {
	public void login(String code);

	public OAuthProviderEnum getProvider();
}
