package lotto.model;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위 밖의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 47, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 출력한다")
    @Test
    void convertLottoNumberToString() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @ParameterizedTest
    @MethodSource("provideParametersForLotto")
    @DisplayName("로또의 당첨 여부를 반환한다.")
    void throwExceptionForSize(Lotto lotto, Prize prize) {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonus = 7;
        assertThat(lotto.compare(winningNumbers, bonus)).isEqualTo(prize);
    }

    private static Stream<Arguments> provideParametersForLotto() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Prize.SIX),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Prize.FIVE_BONUS),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), Prize.FIVE),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 8, 9)), Prize.FOUR),
                Arguments.of(new Lotto(List.of(1, 2, 3, 8, 9, 10)), Prize.THREE),
                Arguments.of(new Lotto(List.of(1, 2, 8, 9, 10, 11)), Prize.NOTHING)
        );
    }
}
