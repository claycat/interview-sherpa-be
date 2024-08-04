package com.sherpa.auth.security.userattributes;

import java.util.Map;

public interface OAuthAttributesMapper {
	OAuthAttributes mapFromAttributes(Map<String, Object> attributes);
}
