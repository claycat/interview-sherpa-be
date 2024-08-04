package com.sherpa.auth.security.userattributes;

import java.util.Map;

public class GoogleOAuthAttributesMapper implements OAuthAttributesMapper {
	@Override
	public OAuthAttributes mapFromAttributes(Map<String, Object> attributes) {
		return OAuthAttributes.builder()
			.attributes(attributes)
			.name((String)attributes.get("name"))
			.email((String)attributes.get("email"))
			.profileURL((String)attributes.get("picture"))
			.build();
	}
}
