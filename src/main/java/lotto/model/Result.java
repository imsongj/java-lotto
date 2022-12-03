package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private static final int INITIAL_VALUE = 0;
    private static final int INCREMENT_VALUE = 1;
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
}
