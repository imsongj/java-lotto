package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @DisplayName("총 상금을 계산한다.")
    @Test
    void calculateTotalPrize() {
        Result result = new Result();
        result.add(Prize.FIVE);
        result.add(Prize.THREE);
        result.add(Prize.FOUR);
        result.add(Prize.FOUR);
        assertThat(result.calculateTotalPrize()).isEqualTo(1_605_000);
    }

    @DisplayName("총 로또 개수을 계산한다.")
    @Test
    void calculateTotalNumberOfLotto() {
        Result result = new Result();
        result.add(Prize.FIVE);
        result.add(Prize.THREE);
        result.add(Prize.FOUR);
        result.add(Prize.FOUR);
        assertThat(result.calculateNumberOfTickets()).isEqualTo(4);
    }

    @DisplayName("총 수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        Result result = new Result();
        result.add(Prize.FIVE);
        result.add(Prize.THREE);
        result.add(Prize.FOUR);
        result.add(Prize.FOUR);
        assertThat(result.getProfitRate()).isEqualTo(40125.0);
    }
}
