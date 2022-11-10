package lotto.exception;

import java.util.List;
import java.util.regex.Pattern;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoStatistic;
import lotto.userinterface.Output;

public class ExceptionHandler {
    public ExceptionHandler() {
    }

    public static void isListCorrectSize(List<Integer> numbers, int size) {
        if (numbers.size() != size) {
            Output.printMessage(ErrorMessage.NOT_CORRECT_SIZE_ERROR.getMessage(size));
            throw new IllegalArgumentException();
        }
    }

    public static void isNumeric(String input) {
        String pattern = "^[0-9]*$";
        if (input == null) {
            Output.printMessage(ErrorMessage.NOT_NUMERIC_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
        if (!Pattern.matches(pattern, input)) {
            Output.printMessage(ErrorMessage.NOT_NUMERIC_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void isMultipleOf(long target, int multiple) {
        if (target % multiple != 0) {
            Output.printMessage(ErrorMessage.NOT_MULTIPLE_ERROR.getMessage(multiple));
            throw new IllegalArgumentException();
        }
    }
}
