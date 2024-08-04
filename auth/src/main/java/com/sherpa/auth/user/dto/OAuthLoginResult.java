package com.sherpa.auth.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(force = true)
public class OAuthLoginResult {

	private final String accessToken;

	@Builder
	public OAuthLoginResult(String accessToken) {
		this.accessToken = accessToken;
	}

}
