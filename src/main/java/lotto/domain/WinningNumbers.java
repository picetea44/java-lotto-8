package lotto.domain;

import java.util.List;
import java.util.Objects;

public final class WinningNumbers {
    private final Lotto winning;
    private final int bonus;

    public WinningNumbers(Lotto winning, int bonus) {
        this.winning = winning;

        validateBonusNumber(bonus);

        List<Integer> winningNumbers = winning.getNumbers();
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        this.bonus = bonus;
    }

    private static void validateBonusNumber(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
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
