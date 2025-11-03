package lotto.app;

import lotto.adapter.LottoNumbersParser;
import lotto.adapter.MoneyParser;
import lotto.domain.*;
import lotto.io.Input;
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
        LottoPurchaseAmount amount = readPurchaseAmount();
        List<Lotto> tickets = issueAndPrintTickets(amount);
        WinningNumbers winningNumbers = readWinningNumbers();
        printResult(tickets, winningNumbers, amount);
    }

    private List<Lotto> issueAndPrintTickets(LottoPurchaseAmount amount) {
        List<Lotto> tickets = new TicketIssuer(numberSource).issue(amount);
        Output.printPurchased(tickets.size());
        Output.printTickets(tickets);
        return tickets;
    }

    private void printResult(List<Lotto> tickets, WinningNumbers winningNumbers, LottoPurchaseAmount amount) {
        Map<Rank, Long> counts = aggregate(tickets, winningNumbers);
        Output.printStatsHeader();
        Output.printStats(counts);

        long totalPrize = ProfitCalculator.totalPrize(counts);
        double yield = ProfitCalculator.yieldPercent(totalPrize, amount.amount());
        Output.printYield(yield);
    }

    private LottoPurchaseAmount readPurchaseAmount() {
        return Input.readWithRetry("구입금액을 입력해 주세요.", input -> {
            long amount = MoneyParser.parsePositiveLongStrict(input);
            return LottoPurchaseAmount.of(amount);
        });
    }

    private WinningNumbers readWinningNumbers() {
        Lotto winning = readWinning();
        int bonus = readBonus();
        return new WinningNumbers(winning, bonus);
    }

    private Lotto readWinning() {
        return Input.readWithRetry("당첨 번호를 입력해 주세요.", input -> {
            List<Integer> numbers = LottoNumbersParser.parseCommaSeparatedInts(input);
            return new Lotto(numbers);
        });
    }

    private int readBonus() {
        return Input.readWithRetry("보너스 번호를 입력해 주세요.", input -> {
            long value = MoneyParser.parsePositiveLongStrict(input);
            return Math.toIntExact(value);
        });
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