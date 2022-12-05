package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lotto.model.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OutputViewTest {
    @ParameterizedTest
    @MethodSource("provideParametersForPrize")
    @DisplayName("당첨 결과를 문자열로 반환한다.")
    void convertPrizeToString(Prize prize, int count, String result) {
        assertThat(new OutputView().convertPrizeToString(prize, count)).isEqualTo(result);
    }

    private static Stream<Arguments> provideParametersForPrize() {
        return Stream.of(
                Arguments.of(Prize.FOUR, 2, "4개 일치 (50,000원) - 2개"),
                Arguments.of(Prize.FIVE_BONUS, 0, "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개")
        );
    }
}
