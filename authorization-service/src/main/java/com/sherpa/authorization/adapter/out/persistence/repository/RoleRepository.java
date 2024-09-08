package com.sherpa.authorization.adapter.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sherpa.authorization.adapter.out.persistence.entity.RoleJpaEntity;

public interface RoleRepository extends JpaRepository<RoleJpaEntity, UUID> {
}
