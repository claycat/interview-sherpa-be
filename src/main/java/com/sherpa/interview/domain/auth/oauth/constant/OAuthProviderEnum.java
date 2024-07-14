package com.sherpa.interview.domain.auth.oauth.constant;

public enum OAuthProviderEnum {

	GOOGLE;

	public static OAuthProviderEnum from(String type) {
		return OAuthProviderEnum.valueOf(type.toUpperCase());
	}

}
