package lotto.adapter;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersParserTest {
    @Test
    void 콤마_구분_숫자만_허용() {
        assertThat(LottoNumbersParser.parseCommaSeparatedInts("1, 2, 3, 4, 5, 6"))
                .containsExactly(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> LottoNumbersParser.parseCommaSeparatedInts("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoNumbersParser.parseCommaSeparatedInts("1, 2, 3, 4, 5, 6.0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}