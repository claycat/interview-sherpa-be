package com.sherpa.member.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sherpa.member.user.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	Optional<Member> findByEmail(String email);
}
