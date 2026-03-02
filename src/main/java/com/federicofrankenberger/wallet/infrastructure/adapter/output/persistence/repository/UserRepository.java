package com.federicofrankenberger.wallet.infrastructure.adapter.output.persistence.repository;

import com.federicofrankenberger.wallet.infrastructure.adapter.output.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
