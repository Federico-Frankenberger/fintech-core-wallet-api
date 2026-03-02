package com.federicofrankenberger.wallet.infrastructure.adapter.output.persistence.repository;

import com.federicofrankenberger.wallet.infrastructure.adapter.output.persistence.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WalletRepository extends JpaRepository<WalletEntity, UUID> {
    Optional<WalletEntity> findByUser_Id(UUID userId);
}
