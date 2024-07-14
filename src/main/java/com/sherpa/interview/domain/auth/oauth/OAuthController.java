package com.sherpa.interview.domain.auth.oauth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sherpa.interview.domain.auth.oauth.constant.OAuthProviderEnum;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RestController
@RequestMapping("/oauth")
@RequiredArgsConstructor
public class OAuthController {

	private final OAuthService oAuthService;

	@SneakyThrows
	@GetMapping("/{oauthProvider}")
	ResponseEntity<Void> redirectAuthCodeRequestUrl(@PathVariable("oauthProvider") OAuthProviderEnum oAuthProviderEnum,
		HttpServletResponse response) {
		String redirectUrl = oAuthService.getAuthCodeRequestUrl(oAuthProviderEnum);
		response.sendRedirect(redirectUrl);
		return ResponseEntity.ok().build();
	}

}

