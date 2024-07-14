package com.sherpa.interview.domain.auth.oauth.google;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "oauth.google")
public record GoogleOAuthMetadata(
	String redirectUri,
	String clientId,
	String clientSecret,
	String[] scope
) {
}
