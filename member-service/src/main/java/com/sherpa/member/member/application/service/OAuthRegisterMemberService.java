package com.sherpa.member.member.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.member.common.annotation.UseCase;
import com.sherpa.member.member.application.port.in.OAuthRegisterMemberCommand;
import com.sherpa.member.member.application.port.in.OAuthRegisterMemberUseCase;
import com.sherpa.member.member.application.port.out.LoadMemberPort;
import com.sherpa.member.member.application.port.out.SaveMemberPort;
import com.sherpa.member.member.domain.Member;

@Component
@UseCase
public class OAuthRegisterMemberService implements OAuthRegisterMemberUseCase {

	private final SaveMemberPort saveMemberPort;
	private final LoadMemberPort loadMemberPort;

	@Autowired
	public OAuthRegisterMemberService(SaveMemberPort saveMemberPort, LoadMemberPort loadMemberPort) {
		this.saveMemberPort = saveMemberPort;
		this.loadMemberPort = loadMemberPort;
	}

	@Override
	@Transactional
	public void registerMember(OAuthRegisterMemberCommand command) {

		var member = loadMemberPort.loadMemberOrNull(command.getEmail());
		if (member.isPresent()) {
			return;
		}

		Member newMember = Member.withoutId(
			command.getEmail(),
			command.getName(),
			command.getProfileURL()
		);

		saveMemberPort.saveMember(newMember);
	}
}
