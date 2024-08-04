package com.sherpa.auth.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.auth.user.dto.OAuthRegisterMemberCommand;
import com.sherpa.auth.user.entity.Member;
import com.sherpa.auth.user.repository.MemberRepository;

@Service
@Transactional(readOnly = true)
public class OAuthRegisterMemberService {

	private final MemberRepository memberRepository;

	public OAuthRegisterMemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void registerOAuthMember(OAuthRegisterMemberCommand command) {

		var member = memberRepository.findByEmail(command.getEmail());
		if (!member.isEmpty()) {
			return;
		}

		var newMember = Member.builder()
			.email(command.getEmail())
			.name(command.getName())
			.profileUrl(command.getProfileUrl())
			.build();

		memberRepository.save(newMember);
	}

}
