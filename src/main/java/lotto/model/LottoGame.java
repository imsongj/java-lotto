package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> tickets;
    private final Referee referee;

    public LottoGame() {
        tickets = new ArrayList<>();
        referee = new Referee();
    }

    public void buyLotto(long money) {
        for (int count = 0; count < calculateNumberOfLotto(money); count++) {
            tickets.add(LottoMachine.createLotto());
        }
    }

    public int calculateNumberOfLotto(long money) {
        return (int)(money / LottoStatistic.PRICE.getValue());
    }
}
