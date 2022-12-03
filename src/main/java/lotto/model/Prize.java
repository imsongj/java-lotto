package lotto.model;

public enum Prize {
    THREE(3, false, 5_000),
    FOUR(4,  false, 50_000),
    FIVE(5, false, 1_500_000),
    FIVE_BONUS(5, true, 30_000_000),
    SIX(6, false, 2_000_000_000),
    NOTHING(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final long prize;

    Prize(int matchCount, boolean matchBonus, long prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static Prize of(int matchCount, boolean matchBonus) {
        if(matchCount != FIVE.matchCount) {
            matchBonus = false;
        }
        for (Prize prize : values()) {
            if (prize.matchCount == matchCount && prize.matchBonus == matchBonus) {
                return prize;
            }
        }
        return NOTHING;
    }
}
