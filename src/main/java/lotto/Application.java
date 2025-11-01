package lotto;

import lotto.app.LottoController;
import lotto.random.RandomsNumberSource;

public class Application {
    public static void main(String[] args) {
        new LottoController(new RandomsNumberSource()).run();
    }
}
