package com.sherpa.member.member.adapter.in.web;

import com.sherpa.member.member.application.port.in.OAuthRegisterMemberCommand;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(force = true)
public class OAuthRegisterMemberRequest {
	private final String email;
	private final String name;
	private final String profileURL;

	@Builder
	public OAuthRegisterMemberRequest(String email, String name, String profileURL) {
		this.email = email;
		this.name = name;
		this.profileURL = profileURL;
	}

	public OAuthRegisterMemberCommand toCommand() {
		return OAuthRegisterMemberCommand.builder()
			.email(email)
			.name(name)
			.profileURL(profileURL)
			.build();
	}

}
