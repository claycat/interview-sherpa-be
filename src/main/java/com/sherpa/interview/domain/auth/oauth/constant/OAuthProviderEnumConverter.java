package com.sherpa.interview.domain.auth.oauth.constant;

import org.springframework.core.convert.converter.Converter;

public class OAuthProviderEnumConverter implements Converter<String, OAuthProviderEnum> {

	@Override
	public OAuthProviderEnum convert(String source) {
		return OAuthProviderEnum.from(source);
	}
}
