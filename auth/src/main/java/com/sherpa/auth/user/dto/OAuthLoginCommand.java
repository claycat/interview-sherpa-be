package com.sherpa.auth.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(force = true)
public class OAuthLoginCommand {

	private final String email;

	@Builder
	public OAuthLoginCommand(String email) {
		this.email = email;
	}
}
