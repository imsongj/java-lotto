package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> convertTicketsToString() {
        return tickets
                .stream()
                .map(Lotto::toString)
                .collect(Collectors.toList());
    }
}
