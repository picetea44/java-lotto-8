package lotto.domain;

import java.util.Map;

public final class ProfitCalculator {
    private ProfitCalculator() {
    }

    public static long totalPrize(Map<Rank, Long> counts) {
        return counts.entrySet().stream()
                .mapToLong(e -> e.getKey().prize * e.getValue())
                .sum();
    }

    public static double yieldPercent(long totalPrize, long totalCost) {
        return (double) totalPrize / totalCost * 100.0;
    }
}
