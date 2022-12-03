package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoGameTest {
    @ParameterizedTest
    @CsvSource({
            "3000, 3",
            "20000, 20",
            "1000, 1"
    })
    @DisplayName("구입 금액에 따라 로또를 구매한다.")
    void buyLotto(long money, int count) {
        assertThat(new LottoGame().calculateNumberOfLotto(money)).isEqualTo(count);
    }


}
