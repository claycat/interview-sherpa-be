package com.sherpa.auth.user;

import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sherpa.auth.security.JwtService;
import com.sherpa.auth.security.userattributes.OAuthAttributesFactory;
import com.sherpa.auth.user.dto.OAuthSignInCommand;
import com.sherpa.auth.user.usecase.OAuthSignInUseCase;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OAuthSignInController {

	private final JwtService jwtService;
	private final OAuthAttributesFactory oAuthAttributesFactory;
	private final OAuthSignInUseCase oAuthSignInUseCase;

	public OAuthSignInController(JwtService jwtService, OAuthAttributesFactory oAuthAttributesFactory,
		OAuthSignInUseCase oAuthSignInUseCase
	) {
		this.jwtService = jwtService;
		this.oAuthAttributesFactory = oAuthAttributesFactory;
		this.oAuthSignInUseCase = oAuthSignInUseCase;
	}

	@GetMapping("/signInSuccess")
	@ResponseStatus(HttpStatus.SEE_OTHER)
	public void signIn(OAuth2AuthenticationToken authentication, HttpServletResponse response) {

		OAuth2User user = authentication.getPrincipal();
		var userAttributes = user.getAttributes();

		var oAuthProvider = authentication.getAuthorizedClientRegistrationId();
		var attributes = oAuthAttributesFactory.createOAuthAttributes(oAuthProvider, userAttributes);

		var oAuthSignInCommand = OAuthSignInCommand.fromOAuthAttributes(attributes);
		var oAuthSignInResult = oAuthSignInUseCase.oAuthSignIn(oAuthSignInCommand);

		var accessToken = oAuthSignInResult.getAccessToken();
		response.addHeader("Set-Cookie", "accessToken=" + accessToken + "; Path=/; HttpOnly; Secure; SameSite=None");
		response.setHeader("Location", "http://localhost:3000");
	}
}