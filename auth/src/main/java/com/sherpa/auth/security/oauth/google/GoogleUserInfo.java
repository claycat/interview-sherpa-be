package com.sherpa.auth.security.oauth.google;

import lombok.Builder;

@Builder
public record GoogleUserInfo(
	String email,
	String name,
	String pictureUrl
) {
}
