-- Tabla de Users
CREATE TABLE users (
                       id UUID PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       wallet_id UUID
);

-- Tabla de Wallets
CREATE TABLE wallets (
                         id UUID PRIMARY KEY,
                         user_id UUID NOT NULL,
                         balance DECIMAL(19, 4) NOT NULL DEFAULT 0.0000,
                         currency VARCHAR(3) NOT NULL DEFAULT 'USD',
                         created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         CONSTRAINT fk_user_wallet FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Índice para búsquedas rápidas por usuario
CREATE INDEX idx_wallet_user_id ON wallets(user_id);