package com.sherpa.auth.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(force = true)
public class OAuthSignInResult {

	private final String accessToken;

	@Builder
	public OAuthSignInResult(String accessToken) {
		this.accessToken = accessToken;
	}
}
