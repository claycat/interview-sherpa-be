package com.sherpa.member.user.dto;

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
	private final String profileURL;

	@Builder
	public OAuthRegisterMemberCommand(String email, String name, String profileURL) {
		this.email = email;
		this.name = name;
		this.profileURL = profileURL;
	}

}
