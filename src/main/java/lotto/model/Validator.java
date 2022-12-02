package lotto.model;

import java.util.regex.Pattern;

public class Validator {
    private static final String MONEY_PATTERN = "^[0-9]*$";

    public static void validateMoney(String input) {
        validateNumeric(input);
        validateDivisible(input);
    }

    public static void validateNumeric(String input) {
        if (input == null || !Pattern.matches(MONEY_PATTERN, input)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDivisible(String input) {
        try {
            long number = Long.parseLong(input);
            if (number == 0 || number % LottoStatistic.PRICE.getValue() != 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateSize(){}
}
