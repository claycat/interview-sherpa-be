package com.sherpa.member.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sherpa.member.user.dto.OAuthRegisterMemberRequest;
import com.sherpa.member.user.usecase.OAuthRegisterMemberUseCase;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/member")
public class OAuthMemberController {

	private final OAuthRegisterMemberUseCase oAuthRegisterMemberUseCase;

	public OAuthMemberController(OAuthRegisterMemberUseCase oAuthRegisterMemberUseCase) {
		this.oAuthRegisterMemberUseCase = oAuthRegisterMemberUseCase;
	}

	@PostMapping
	public ResponseEntity<?> register(final @RequestBody OAuthRegisterMemberRequest request) {
		oAuthRegisterMemberUseCase.registerOAuthMember(request.toCommand());

		return ResponseEntity.ok().build();
	}

}
