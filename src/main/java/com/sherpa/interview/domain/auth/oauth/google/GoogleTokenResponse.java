package com.sherpa.interview.domain.auth.oauth.google;


public record GoogleTokenResponse(
	String access_token,
	String token_type,
	String refresh_token,
	Long expires_in
) {
}
