package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class ValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "abc",
            "12vv",
            "+42",
            "67+8"
    })
    @DisplayName("입력이 숫자 이외의 문자를 포함하면 예외를 발생시킨다.")
    void throwExceptionForNonNumeric(String input) {
        assertThatThrownBy(() -> Validator.validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "1100",
            "1",
            "2020",
            "140001",
            "abc"
    })
    @DisplayName("입력이 1000으로 나누어 떨어지는 수가 아니면 예외를 발생시킨다.")
    void throwExceptionForNonDivisible(String input) {
        assertThatThrownBy(() -> Validator.validateDivisible(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
