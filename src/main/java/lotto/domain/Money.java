package lotto.domain;

public final class Money {
    private static final int UNIT = 1000;
    private final long amount;

    private Money(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private static void validate(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 양의 정수여야 합니다.");
        }
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
    }

    public static Money of(long amount) {
        return new Money(amount);
    }

    public int ticketCount() {
        return (int) (amount / UNIT);
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
