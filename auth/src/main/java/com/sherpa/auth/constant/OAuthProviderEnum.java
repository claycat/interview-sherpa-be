package com.sherpa.auth.constant;

public enum OAuthProviderEnum {

	GOOGLE;

	public static OAuthProviderEnum from(String type) {
		return OAuthProviderEnum.valueOf(type.toUpperCase());
	}

}
