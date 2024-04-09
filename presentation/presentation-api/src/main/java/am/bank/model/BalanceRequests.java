package am.bank.model;

import jakarta.annotation.Nonnull;

public record BalanceRequests(@Nonnull long userId, double amount) {
}
