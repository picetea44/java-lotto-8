package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    NONE(0, 0L);

    public final int match;
    public final long prize;

    Rank(int match, long prize) {
        this.match = match;
        this.prize = prize;
    }

    public static Rank of(int match, boolean bonusHit) {
        if (match == 6) {
            return FIRST;
        }
        if (match == 5 && bonusHit) {
            return SECOND;
        }
        if (match == 5) {
            return THIRD;
        }
        if (match == 4) {
            return FOURTH;
        }
        if (match == 3) {
            return FIFTH;
        }
        return NONE;
    }
}
