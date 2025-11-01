package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.Comparator;
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
        System.out.printf("3개 일치 (5,000원) - %d개%n", counts.getOrDefault(Rank.FIFTH, 0L));
        System.out.printf("4개 일치 (50,000원) - %d개%n", counts.getOrDefault(Rank.FOURTH, 0L));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", counts.getOrDefault(Rank.THIRD, 0L));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", counts.getOrDefault(Rank.SECOND, 0L));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", counts.getOrDefault(Rank.FIRST, 0L));
    }

    public static void printYield(double percent) {
        System.out.printf("총 수익률은 %.1f%%%n", percent);
    }

    public static void printError(String msg) {
        System.out.println(msg);
    }
}