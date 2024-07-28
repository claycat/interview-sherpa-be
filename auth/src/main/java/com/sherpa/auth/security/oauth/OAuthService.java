package com.sherpa.auth.security.oauth;

import com.sherpa.auth.constant.OAuthProviderEnum;

public interface OAuthService {
	public void login(String code);

	public OAuthProviderEnum getProvider();
}