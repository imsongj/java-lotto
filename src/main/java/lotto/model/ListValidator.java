package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListValidator {
    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoStatistic.SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
