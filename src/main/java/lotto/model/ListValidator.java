package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListValidator {
    public static void validateWinningNumbers(List<Integer> winningNumbers, int bonus) {
        List<Integer> numbers = new ArrayList<>(winningNumbers);
        numbers.add(bonus);
        ListValidator.validateSize(numbers, LottoStatistic.SIZE.getValue() + 1);
        ListValidator.validateRange(numbers,
                LottoStatistic.MIN_NUMBER.getValue(), LottoStatistic.MAX_NUMBER.getValue());
        ListValidator.validateDuplicate(numbers);
    }

    public static void validateSize(List<Integer> numbers, int size) {
        if (numbers.size() != size) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRange(List<Integer> numbers, int min, int max) {
        for (int number : numbers) {
            if (number < min || number > max) {
                throw new IllegalArgumentException();
            }
        }
    }
}
