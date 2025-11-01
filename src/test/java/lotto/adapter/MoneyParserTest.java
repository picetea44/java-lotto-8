package lotto.adapter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyParserTest {
    @Test
    void 숫자만_허용한다() {
        assertThat(MoneyParser.parsePositiveLongStrict("1000")).isEqualTo(1000L);
        assertThatThrownBy(() -> MoneyParser.parsePositiveLongStrict("1,000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> MoneyParser.parsePositiveLongStrict("1000.0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> MoneyParser.parsePositiveLongStrict("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}