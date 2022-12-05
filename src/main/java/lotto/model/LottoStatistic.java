package lotto.model;

public enum LottoStatistic {
    PRICE(1000),
    SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int value;

    LottoStatistic(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
