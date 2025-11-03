package lotto.adapter;

import lotto.ErrorMessages;

public final class MoneyParser {
    private MoneyParser() {
    }

    public static long parsePositiveLongStrict(String raw) {
        if (raw == null || raw.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_INPUT_EMPTY);
        }
        String trimedString = raw.trim();
        if (!trimedString.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_INPUT_NOT_INTEGER);
        }
        try {
            return Long.parseLong(trimedString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_INPUT_TOO_LARGE);
        }
    }
}