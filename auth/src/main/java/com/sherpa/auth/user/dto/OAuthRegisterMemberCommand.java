package com.sherpa.auth.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(force = true)
public class OAuthRegisterMemberCommand {
	private final String email;
	private final String name;
	private final String profileUrl;

	@Builder
	public OAuthRegisterMemberCommand(String email, String name, String profileUrl) {
		this.email = email;
		this.name = name;
		this.profileUrl = profileUrl;
	}

}
