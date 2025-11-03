package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.function.Function;

public final class Input {
    private Input() {
    }

    public static <T> T readWithRetry(String prompt, Function<String, T> parser) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = Console.readLine();
                return parser.apply(input);
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }
}
