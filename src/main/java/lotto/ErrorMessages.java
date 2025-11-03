package lotto;

public final class ErrorMessages {
    private ErrorMessages() {
    }

    // Lotto 관련
    public static final String LOTTO_EMPTY = "[ERROR] 로또 번호가 없습니다.";
    public static final String LOTTO_NOT_SIX = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String LOTTO_OUT_OF_RANGE = "[ERROR] 로또 번호는 1부터 45 사이여야 합니다.";
    public static final String LOTTO_DUPLICATE = "[ERROR] 로또 번호는 서로 중복될 수 없습니다.";

    // Money 관련
    public static final String MONEY_MUST_BE_POSITIVE = "[ERROR] 금액은 양의 정수여야 합니다.";

    // LottoPurchaseAmount 관련
    public static final String LOTTO_PURCHASE_MUST_BE_UNIT = "[ERROR] 금액은 1000원 단위여야 합니다.";

    // WinningNumbers 관련
    public static final String BONUS_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String BONUS_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.";

    // MoneyParser 관련
    public static final String MONEY_INPUT_EMPTY = "[ERROR] 금액을 입력하세요.";
    public static final String MONEY_INPUT_NOT_INTEGER = "[ERROR] 정수 금액만 입력하세요.";
    public static final String MONEY_INPUT_TOO_LARGE = "[ERROR] 금액이 너무 큽니다.";

    // LottoNumbersParser 관련
    public static final String NUMBERS_INPUT_EMPTY = "[ERROR] 번호를 입력하세요.";
    public static final String NUMBERS_INPUT_NOT_INTEGER = "[ERROR] 숫자만 입력하세요.";
    public static final String NUMBERS_INPUT_OUT_OF_RANGE = "[ERROR] 숫자 범위를 초과했습니다.";
}