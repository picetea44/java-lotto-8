package lotto.domain;

public final class Judge {
    private final WinningNumbers winningNumbers;

    public Judge(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Rank judgeTicket(Lotto ticket) {
        int match = winningNumbers.matchCount(ticket);
        boolean bonus = winningNumbers.bonusHit(ticket);
        return Rank.of(match, bonus);
    }
}