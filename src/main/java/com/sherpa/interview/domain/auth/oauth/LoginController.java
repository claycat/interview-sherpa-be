package com.sherpa.interview.domain.auth.oauth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sherpa.interview.domain.auth.oauth.constant.OAuthProviderEnum;

@RestController
@RequestMapping("/login/oauth2")
public class LoginController {
	@GetMapping("/code/{oauthProvider}")
	public ResponseEntity<Void> login(@PathVariable("oauthProvider") OAuthProviderEnum oAuthProviderEnum,
		@RequestParam("code") String code) {

		System.out.println("code = " + code);

		return ResponseEntity.ok().build();
	}
}
