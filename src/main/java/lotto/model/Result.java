package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private static final int INITIAL_VALUE = 0;
    private static final int INCREMENT_VALUE = 1;
    public static final int RATE_MULTIPLIER = 100;
    private final Map<Prize, Integer> prizeResult;

    public Result() {
        prizeResult = new HashMap<>();
        for (Prize prizeType : Prize.values()) {
            prizeResult.put(prizeType, INITIAL_VALUE);
        }
    }

    public void add(Prize prizeType) {
        prizeResult.merge(prizeType, INCREMENT_VALUE, Integer::sum);
    }

    public double calculateProfitRate() {
        return (double)calculateTotalPrize() / (calculateNumberOfTickets() * LottoStatistic.PRICE.getValue())
                * RATE_MULTIPLIER;
    }

    public long calculateTotalPrize() {
        long total = 0;
        for (Map.Entry<Prize, Integer> entry : prizeResult.entrySet()) {
            total += (entry.getKey().getPrize() * entry.getValue());
        }
        return total;
    }

    public int calculateNumberOfTickets() {
        return prizeResult.values().stream().reduce(0, Integer::sum);
    }
}
