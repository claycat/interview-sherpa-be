package com.sherpa.member.member.adapter.out.persistence;

import java.util.Optional;

import com.sherpa.member.common.annotation.PersistenceAdapter;
import com.sherpa.member.member.application.port.out.LoadMemberPort;
import com.sherpa.member.member.application.port.out.SaveMemberPort;
import com.sherpa.member.member.domain.Member;
import com.sherpa.member.member.exception.MemberNotFoundException;

@PersistenceAdapter
public class MemberPersistenceAdapter implements LoadMemberPort, SaveMemberPort {

	private final MemberRepository memberRepository;
	private final MemberMapper memberMapper;

	public MemberPersistenceAdapter(MemberRepository memberRepository, MemberMapper memberMapper) {
		this.memberRepository = memberRepository;
		this.memberMapper = memberMapper;
	}

	@Override
	public Member loadMember(String email) {
		return memberRepository.findByEmail(email)
			.map(memberMapper::mapToDomainEntity)
			.orElseThrow(() -> new MemberNotFoundException(email));
	}

	@Override
	public Optional<Member> loadMemberOrNull(String email) {
		return memberRepository.findByEmail(email)
			.map(memberMapper::mapToDomainEntity);
	}

	@Override
	public void saveMember(Member member) {
		memberRepository.save(memberMapper.mapToJpaEntity(member));
	}
}
