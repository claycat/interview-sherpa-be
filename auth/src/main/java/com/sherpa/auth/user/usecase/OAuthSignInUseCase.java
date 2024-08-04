package com.sherpa.auth.user.usecase;

import org.springframework.stereotype.Service;

import com.sherpa.auth.user.dto.OAuthLoginCommand;
import com.sherpa.auth.user.dto.OAuthRegisterMemberCommand;
import com.sherpa.auth.user.dto.OAuthSignInCommand;
import com.sherpa.auth.user.dto.OAuthSignInResult;
import com.sherpa.auth.user.service.OAuthLoginService;
import com.sherpa.auth.user.service.OAuthRegisterMemberService;

@Service
public class OAuthSignInUseCase {

	private final OAuthRegisterMemberService oAuthRegisterMemberService;
	private final OAuthLoginService oAuthLoginService;

	public OAuthSignInUseCase(OAuthRegisterMemberService oAuthRegisterMemberService,
		OAuthLoginService oAuthLoginService) {
		this.oAuthRegisterMemberService = oAuthRegisterMemberService;
		this.oAuthLoginService = oAuthLoginService;
	}

	public OAuthSignInResult oAuthSignIn(OAuthSignInCommand signInCommand) {

		var registerCommand = OAuthRegisterMemberCommand.builder()
			.name(signInCommand.getName())
			.email(signInCommand.getEmail())
			.profileUrl(signInCommand.getProfileUrl())
			.build();
		oAuthRegisterMemberService.registerOAuthMember(registerCommand);

		var oAuthLoginCommand = OAuthLoginCommand.builder()
			.email(signInCommand.getEmail())
			.build();

		var oAuthLoginResult = oAuthLoginService.login(oAuthLoginCommand);

		return OAuthSignInResult.builder()
			.accessToken(oAuthLoginResult.getAccessToken())
			.build();
	}

}
