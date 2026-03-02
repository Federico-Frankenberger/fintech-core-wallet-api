package com.federicofrankenberger.wallet.infrastructure.adapter.output.persistence.mapper;

import com.federicofrankenberger.wallet.core.domain.model.User;
import com.federicofrankenberger.wallet.infrastructure.adapter.output.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toModel(UserEntity user);

    UserEntity toEntity(User user);
}
