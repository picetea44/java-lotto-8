package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(longs = {0L, -1000L})
    void 구매금액은_양의_정수여야_한다(long bad) {
        assertThatThrownBy(() -> LottoPurchaseAmount.of(bad))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(longs = {1100L, 999L, 2500L})
    void 구매금액은_1000원_단위여야_한다(long bad) {
        assertThatThrownBy(() -> LottoPurchaseAmount.of(bad))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_금액은_장수_계산이_가능하다() {
        var purchaseAmount = LottoPurchaseAmount.of(8000L);
        assertThat(purchaseAmount.ticketCount()).isEqualTo(8);
    }
}
