package com.sherpa.interview.domain.auth.oauth.google;

public record GoogleTokenResponse(
	String accessToken,
	String tokenType,
	String refreshToken,
	Long expiresIn,
	String idToken
) {
}
