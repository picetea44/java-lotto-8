package lotto.app;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseAmount;
import lotto.random.NumberSource;

import java.util.ArrayList;
import java.util.List;

public final class TicketIssuer {
    private final NumberSource source;
    public TicketIssuer(NumberSource source) { this.source = source; }

    public List<Lotto> issue(LottoPurchaseAmount purchaseAmount) {
        int n = purchaseAmount.ticketCount();
        List<Lotto> tickets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            tickets.add(new Lotto(source.drawSix()));
        }
        return tickets;
    }
}