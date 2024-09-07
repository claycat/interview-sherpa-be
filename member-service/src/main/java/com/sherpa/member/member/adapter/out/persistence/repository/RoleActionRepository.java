package com.sherpa.member.member.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sherpa.member.member.adapter.out.persistence.entity.RoleActionJpaEntity;

public interface RoleActionRepository extends JpaRepository<RoleActionJpaEntity, UUID> {
}
