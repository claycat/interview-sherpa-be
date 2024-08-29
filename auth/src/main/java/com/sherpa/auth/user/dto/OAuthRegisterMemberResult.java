package com.sherpa.auth.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(force = true)
public class OAuthRegisterMemberResult {
	private final String email;
	private final String name;
	private final String profileURL;

	@Builder
	public OAuthRegisterMemberResult(String email, String name, String profileURL) {
		this.email = email;
		this.name = name;
		this.profileURL = profileURL;
	}

	public OAuthRegisterMemberResponse toResponse() {
		return OAuthRegisterMemberResponse.builder()
			.email(email)
			.name(name)
			.profileURL(profileURL)
			.build();
	}
}
