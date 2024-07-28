package com.sherpa.auth.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sherpa.auth.constant.OAuthProviderEnum;
import com.sherpa.auth.security.oauth.OAuthServiceResolver;

import jakarta.servlet.http.HttpServletResponse;
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

	@GetMapping("/{oauthProvider}")
	public void redirectToLogin(@PathVariable("oauthProvider") OAuthProviderEnum oAuthProviderEnum, HttpServletResponse response) {
		log.info(oAuthProviderEnum.toString());
		System.out.println("oAuthProviderEnum = " + oAuthProviderEnum);

		//response.sendRedirect("http://localhost:8080/oauth/logn/");

		return;
	}

	@GetMapping("/login/{oauthProvider}")
	public ResponseEntity<Void> login(@PathVariable("oauthProvider") OAuthProviderEnum oAuthProviderEnum,
		@RequestParam("code") String code) {
		var oAuthService = oAuthServiceResolver.resolve(oAuthProviderEnum);
		oAuthService.login(code);

		return ResponseEntity.ok().build();
	}

}