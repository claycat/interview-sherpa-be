package com.sherpa.interview.domain.auth.oauth.google;

import static com.fasterxml.jackson.databind.PropertyNamingStrategies.*;

import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
public record GoogleToken(
	String accessToken,
	String tokenType,
	Long expiresIn,
	String refreshToken,
	String scope,
	String idToken
) {

}
