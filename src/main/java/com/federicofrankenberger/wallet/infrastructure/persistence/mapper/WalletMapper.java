package com.federicofrankenberger.wallet.infrastructure.persistence.mapper;

import com.federicofrankenberger.wallet.core.domain.model.Wallet;
import com.federicofrankenberger.wallet.infrastructure.persistence.entity.WalletEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    //Entity -> Model
    @Mapping(source = "user.id", target = "userId")
    Wallet toModel(WalletEntity wallet);

    //Model -> Entity
    @Mapping(target = "user", ignore = true)
    WalletEntity toEntity(Wallet wallet);
}
