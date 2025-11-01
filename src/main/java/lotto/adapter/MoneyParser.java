package lotto.adapter;

public final class MoneyParser {
    private MoneyParser() {
    }

    public static long parsePositiveLongStrict(String raw) {
        if (raw == null || raw.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 금액을 입력하세요.");
        }
        String trimedString = raw.trim();
        if (!trimedString.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 정수 금액만 입력하세요.");
        }
        try {
            return Long.parseLong(trimedString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액이 너무 큽니다.");
        }
    }
}