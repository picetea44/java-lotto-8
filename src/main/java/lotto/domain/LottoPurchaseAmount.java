package lotto.domain;

import lotto.ErrorMessages;

public final class LottoPurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private final Money money;

    private LottoPurchaseAmount(Money money) {
        validate(money);
        this.money = money;
    }

    private static void validate(Money money) {
        if (money.amount() % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_PURCHASE_MUST_BE_UNIT);
        }
    }

    public static LottoPurchaseAmount of(long amount) {
        return new LottoPurchaseAmount(Money.of(amount));
    }

    public int ticketCount() {
        return (int) (money.amount() / LOTTO_PRICE);
    }

    public long amount() {
        return money.amount();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof LottoPurchaseAmount lpa) && lpa.money.equals(money);
    }

    @Override
    public int hashCode() {
        return money.hashCode();
    }

    @Override
    public String toString() {
        return money.toString();
    }
}