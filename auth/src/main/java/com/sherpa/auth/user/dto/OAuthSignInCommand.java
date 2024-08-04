package com.sherpa.auth.user.dto;

import com.sherpa.auth.security.userattributes.OAuthAttributes;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(force = true)
public class OAuthSignInCommand {

	private final String email;
	private final String name;
	private final String profileUrl;

	@Builder
	public OAuthSignInCommand(String email, String name, String profileUrl) {
		this.email = email;
		this.name = name;
		this.profileUrl = profileUrl;
	}

	public static OAuthSignInCommand fromOAuthAttributes(OAuthAttributes attributes) {
		return OAuthSignInCommand.builder()
			.email(attributes.getEmail())
			.name(attributes.getName())
			.profileUrl(attributes.getProfileURL())
			.build();
	}

}
