package com.sherpa.auth.security.userattributes;

import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class OAuthAttributes {
	private final Map<String, Object> attributes;
	private final String name;
	private final String email;
	private final String profileURL;
}
