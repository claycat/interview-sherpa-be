package com.sherpa.member.member.adapter.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sherpa.member.member.application.port.in.OAuthRegisterMemberUseCase;

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
		oAuthRegisterMemberUseCase.registerMember(request.toCommand());

		return ResponseEntity.ok().build();
	}

}
