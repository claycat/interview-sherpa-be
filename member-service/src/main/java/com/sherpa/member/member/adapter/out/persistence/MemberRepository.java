package com.sherpa.member.member.adapter.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberJpaEntity, String> {

	Optional<MemberJpaEntity> findByEmail(String email);
}
