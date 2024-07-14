package com.sherpa.interview.domain.auth.oauth.urlgenerator;

import com.sherpa.interview.domain.auth.oauth.constant.OAuthProviderEnum;

public interface OAuthRequestUrlGenerator {
	OAuthProviderEnum getProvider();

	String generate();
}
