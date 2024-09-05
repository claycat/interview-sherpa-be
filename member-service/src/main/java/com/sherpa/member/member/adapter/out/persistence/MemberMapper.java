package com.sherpa.member.member.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.sherpa.member.member.domain.Member;

@Component
class MemberMapper {

	Member mapToDomainEntity(MemberJpaEntity memberJpaEntity) {
		return Member.withId(
			memberJpaEntity.getId(),
			memberJpaEntity.getEmail(),
			memberJpaEntity.getName(),
			memberJpaEntity.getProfileURL()
		);
	}

	MemberJpaEntity mapToJpaEntity(Member member) {
		return MemberJpaEntity.builder()
			.email(member.getEmail())
			.name(member.getName())
			.profileURL(member.getProfileURL())
			.build();
	}

}
