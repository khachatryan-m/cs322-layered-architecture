package am.bank.model;

import jakarta.annotation.Nonnull;

public record CreateAccountRequest(@Nonnull long userId) {
}
