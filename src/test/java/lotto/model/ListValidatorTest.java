package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class ListValidatorTest {
    @ParameterizedTest
    @MethodSource("provideParametersForSize")
    @DisplayName("리스트 사이즈가 6 이상이면 예외를 발생시킨다.")
    void throwExceptionForSize(List<Integer> numbers, int size) {
        assertThatThrownBy(() -> ListValidator.validateSize(numbers, size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideParametersForSize() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 0, 3, 4), 6),
                Arguments.of(List.of(), 6),
                Arguments.of(List.of(-1, 2, 0, 2, 3, 6, 7, 8), 6)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForDuplicate")
    @DisplayName("리스트에 중복된 숫자가 존재하면 예외를 발생시킨다.")
    void throwExceptionForDuplicate(List<Integer> numbers) {
        assertThatThrownBy(() -> ListValidator.validateDuplicate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideParametersForDuplicate() {
        return Stream.of(
                Arguments.of(List.of(1, 1)),
                Arguments.of(List.of(1,2,3,4,5,5)),
                Arguments.of(List.of(3,3,3,3,3,3))
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForWinningNumbers")
    @DisplayName("잘못된 당첨 번호와 보너스 번호가 입력되면 예외를 발생시킨다.")
    void throwExceptionForInvalidWinning(List<Integer> winningNumbers, int bonus) {
        assertThatThrownBy(() -> ListValidator.validateWinningNumbers(winningNumbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideParametersForWinningNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7, 8), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7, 8), 46),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7, 46), 8)
        );
    }
}
