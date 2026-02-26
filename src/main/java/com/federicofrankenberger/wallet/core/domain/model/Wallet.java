package com.federicofrankenberger.wallet.core.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record Wallet(
        UUID id,
        UUID userId,
        BigDecimal balance,
        String currency,
        LocalDateTime createdAT
) {
    public Wallet {
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El balance no puede ser negativo");
        }
    }

    public boolean hasEnoughBalance(BigDecimal amount){
        return balance.compareTo(amount) >= 0;
    }

}

