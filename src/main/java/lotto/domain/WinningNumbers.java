package lotto.domain;

import java.util.List;
import java.util.Objects;

import lotto.ErrorMessages;

public final class WinningNumbers {
    private final Lotto winning;
    private final int bonus;

    public WinningNumbers(Lotto winning, int bonus) {
        this.winning = winning;

        validateBonusNumber(bonus);

        List<Integer> winningNumbers = winning.getNumbers();
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_DUPLICATE);
        }
        this.bonus = bonus;
    }

    private static void validateBonusNumber(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_OUT_OF_RANGE);
        }
    }

    public int matchCount(Lotto t) {
        int cnt = 0;
        for (int n : t.getNumbers()) {
            if (winning.getNumbers().contains(n)) {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean bonusHit(Lotto t) {
        return t.getNumbers().contains(bonus);
    }

    public Lotto winning() {
        return winning;
    }

    public int bonus() {
        return bonus;
    }
}
