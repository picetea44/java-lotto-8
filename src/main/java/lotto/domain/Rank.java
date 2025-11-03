package lotto.domain;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public enum Rank {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NONE(0, false, 0L);

    private final int match;
    private final boolean bonusRequired;
    private final long prize;

    Rank(int match, boolean bonusRequired, long prize) {
        this.match = match;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
    }

    public int getMatch() {
        return match;
    }

    public long getPrize() {
        return prize;
    }

    public String getDescription() {
        if (this == NONE) {
            return "";
        }

        String matchText = match + "개 일치";
        if (bonusRequired) {
            matchText += ", 보너스 볼 일치";
        }

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        String prizeText = numberFormat.format(prize);

        return String.format("%s (%s원)", matchText, prizeText);
    }

    public static Rank of(int match, boolean bonusHit) {
        return Arrays.stream(values())
                .filter(rank -> rank != NONE)
                .filter(rank -> rank.match == match)
                .filter(rank -> rank.bonusRequired == bonusHit)
                .findFirst()
                .orElse(NONE);
    }
}
