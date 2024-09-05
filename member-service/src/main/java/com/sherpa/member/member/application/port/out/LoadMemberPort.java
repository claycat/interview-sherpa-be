package com.sherpa.member.member.application.port.out;

import java.util.Optional;

import com.sherpa.member.member.domain.Member;

public interface LoadMemberPort {

	Member loadMember(String email);

	Optional<Member> loadMemberOrNull(String email);
}
