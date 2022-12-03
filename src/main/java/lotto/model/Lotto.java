package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ListValidator.validateSize(numbers, LottoStatistic.SIZE.getValue());
        ListValidator.validateDuplicate(numbers);
        ListValidator.validateRange(numbers,
                LottoStatistic.MIN_NUMBER.getValue(), LottoStatistic.MAX_NUMBER.getValue());
    }

    public Prize compare(List<Integer> winningNumbers, int bonus) {
        int matchCount = 0;
        boolean matchBonus = numbers.contains(bonus);
        for (int number : winningNumbers) {
            if (numbers.contains(number)) {
                matchCount++;
            }
        }
        return Prize.of(matchCount, matchBonus);
    }

    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }
}
