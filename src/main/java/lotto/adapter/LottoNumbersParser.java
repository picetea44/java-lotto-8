package lotto.adapter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.ErrorMessages;

public final class LottoNumbersParser {
    private LottoNumbersParser() {
    }

    public static List<Integer> parseCommaSeparatedInts(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.NUMBERS_INPUT_EMPTY);
        }
        List<Integer> ints = Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(LottoNumbersParser::toIntStrict)
                .collect(Collectors.toList());
        return ints;
    }

    private static int toIntStrict(String s) {
        if (!s.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessages.NUMBERS_INPUT_NOT_INTEGER);
        }
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NUMBERS_INPUT_OUT_OF_RANGE);
        }
    }
}