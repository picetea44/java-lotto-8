package lotto.app;

import camp.nextstep.edu.missionutils.Console;
import lotto.adapter.LottoNumbersParser;
import lotto.adapter.MoneyParser;
import lotto.domain.*;
import lotto.io.Output;
import lotto.random.NumberSource;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class LottoController {
    private final NumberSource numberSource;

    public LottoController(NumberSource numberSource) {
        this.numberSource = numberSource;
    }

    public void run() {
        Money money = readMoney();
        List<Lotto> tickets = new TicketIssuer(numberSource).issue(money);
        Output.printPurchased(tickets.size());
        Output.printTickets(tickets);

        WinningNumbers wn = readWinningNumbers();
        Map<Rank, Long> counts = aggregate(tickets, wn);

        Output.printStatsHeader();
        Output.printStats(counts);

        long totalPrize = ProfitCalculator.totalPrize(counts);
        double yield = ProfitCalculator.yieldPercent(totalPrize, money.amount());
        Output.printYield(yield);

        Console.close(); // missionutils 권장
    }

    private Money readMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String raw = Console.readLine();
                long amount = MoneyParser.parsePositiveLongStrict(raw); // 형식
                return Money.of(amount); // 도메인 규칙
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private WinningNumbers readWinningNumbers() {
        Lotto winning = readWinning();
        int bonus = readBonus();
        return new WinningNumbers(winning, bonus);
    }

    private Lotto readWinning() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String raw = Console.readLine(); // "1,2,3,4,5,6"
                List<Integer> ints = LottoNumbersParser.parseCommaSeparatedInts(raw); // 형식
                return new Lotto(ints); // 개수/범위/중복 규칙
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private int readBonus() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String raw = Console.readLine();
                long v = MoneyParser.parsePositiveLongStrict(raw); // 정수 형식만 재사용
                return Math.toIntExact(v); // 범위/중복은 WinningNumbers가 검사
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private Map<Rank, Long> aggregate(List<Lotto> tickets, WinningNumbers wn) {
        Judge judge = new Judge(wn);
        return tickets.stream()
                .map(judge::judgeTicket)
                .collect(Collectors.groupingBy(
                        r -> r, () -> new EnumMap<>(Rank.class), Collectors.counting()
                ));
    }
}