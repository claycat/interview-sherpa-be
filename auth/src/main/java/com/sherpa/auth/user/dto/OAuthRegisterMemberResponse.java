package com.sherpa.auth.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(force = true)
public class OAuthRegisterMemberResponse {
	private final String email;
	private final String name;
	private final String profileURL;

	@Builder
	public OAuthRegisterMemberResponse(String email, String name, String profileURL) {
		this.email = email;
		this.name = name;
		this.profileURL = profileURL;
	}
}
