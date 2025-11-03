package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public final class Output {
    private Output() {
    }

    public static void printPurchased(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printTickets(List<Lotto> tickets) {
        for (Lotto t : tickets) {
            List<Integer> sorted = t.getNumbers().stream().sorted().toList();
            System.out.println(sorted);
        }
    }

    public static void printStatsHeader() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printStats(Map<Rank, Long> counts) {
        for (Rank rank : List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)) {
            long count = counts.getOrDefault(rank, 0L);
            System.out.printf("%s - %d개%n", rank.getDescription(), count);
        }
    }

    public static void printYield(double percent) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", percent);
    }

    public static void printError(String msg) {
        System.out.println(msg);
    }
}