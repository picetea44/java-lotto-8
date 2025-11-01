package lotto.adapter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoNumbersParser {
    private LottoNumbersParser() {
    }

    public static List<Integer> parseCommaSeparatedInts(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 번호를 입력하세요.");
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
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위를 초과했습니다.");
        }
    }
}