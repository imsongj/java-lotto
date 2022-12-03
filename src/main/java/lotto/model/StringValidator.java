package lotto.model;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringValidator {
    private static final String MONEY_PATTERN = "^[0-9]*$";

    public static void validateNumeric(String input) {
        if (input == null || !Pattern.matches(MONEY_PATTERN, input)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDivisible(String input, int divisor) {
        validateLong(input);
        long number = Long.parseLong(input);
        if (number == 0 || number % divisor != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateLong(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIntegerList(String input, String delimiter) {
        try {
            Stream.of(input.split(delimiter))
                    .map(String::trim)
                    .forEach(Integer::parseInt);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }
}
