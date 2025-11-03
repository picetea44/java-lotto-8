package lotto.domain;

import lotto.ErrorMessages;

public final class Money {
    private final long amount;

    private Money(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private static void validate(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_MUST_BE_POSITIVE);
        }
    }

    public static Money of(long amount) {
        return new Money(amount);
    }

    public long amount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Money m) && m.amount == amount;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(amount);
    }

    @Override
    public String toString() {
        return amount + "원";
    }
}
