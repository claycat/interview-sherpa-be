package com.sherpa.member.member.application.port.out;

import com.sherpa.member.member.domain.Member;

public interface SaveMemberPort {

	void saveMember(Member member);
}
