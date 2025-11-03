package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(longs = {0L, -1000L})
    void 금액은_양의_정수여야_한다(long bad) {
        assertThatThrownBy(() -> Money.of(bad))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
