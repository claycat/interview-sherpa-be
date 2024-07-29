package com.sherpa.auth.security.oauth;

import java.io.IOException;

import com.sherpa.auth.constant.OAuthProviderEnum;

public interface OAuthService {
	public void login(String code) throws IOException;

	public OAuthProviderEnum getProvider();
}