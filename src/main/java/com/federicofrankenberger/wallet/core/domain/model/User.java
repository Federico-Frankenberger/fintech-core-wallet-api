package com.federicofrankenberger.wallet.core.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record User(
        UUID id,
        String username,
        String password,
        String email,
        LocalDateTime createdAt

) {
    public User{
        if(email == null || !email.contains("@")||!email.contains(".")) {
            throw new IllegalArgumentException("El email no respeta el formato correcto");
        }
    }


}
