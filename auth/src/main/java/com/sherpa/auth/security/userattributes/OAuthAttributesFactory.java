package com.sherpa.auth.security.userattributes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class OAuthAttributesFactory {

	private final Map<String, OAuthAttributesMapper> mappers = new HashMap<>();

	public OAuthAttributesFactory() {
		mappers.put("google", new GoogleOAuthAttributesMapper());
	}

	public OAuthAttributes createOAuthAttributes(String provider, Map<String, Object> attributes) {
		OAuthAttributesMapper mapper = mappers.get(provider.toLowerCase());
		if (mapper == null) {
			throw new IllegalArgumentException("No OAuth mapper registered for provider: " + provider);
		}
		return mapper.mapFromAttributes(attributes);
	}

}
