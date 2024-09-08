package com.sherpa.authorization.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sherpa.authorization.adapter.out.persistence.entity.RoleActionJpaEntity;

public interface RoleActionRepository extends JpaRepository<RoleActionJpaEntity, UUID> {
}
