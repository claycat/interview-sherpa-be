package com.sherpa.auth.security.oauth;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sherpa.auth.constant.OAuthProviderEnum;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/oauth")
@Slf4j
public class OAuthController {

	private final OAuthServiceResolver oAuthServiceResolver;

	@Autowired
	public OAuthController(OAuthServiceResolver oAuthServiceResolver) {
		this.oAuthServiceResolver = oAuthServiceResolver;
	}

	@GetMapping("/login/{oauthProvider}")
	public ResponseEntity<Void> login(@PathVariable("oauthProvider") OAuthProviderEnum oAuthProviderEnum,
		@RequestParam("code") String code) {
		var oAuthService = oAuthServiceResolver.resolve(oAuthProviderEnum);

		try {
			oAuthService.login(code);
		} catch (IOException e) {
			//TODO should catch and return some bad status..
		}

		return ResponseEntity.ok().build();
	}

}