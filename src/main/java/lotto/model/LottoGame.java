package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private final List<Lotto> tickets;

    public LottoGame() {
        tickets = new ArrayList<>();
    }

    public void buyLotto(long money) {
        for (int count = 0; count < calculateNumberOfLotto(money); count++) {
            tickets.add(LottoMachine.createLotto());
        }
    }

    public int calculateNumberOfLotto(long money) {
        return (int)(money / LottoStatistic.PRICE.getValue());
    }

    public Result getResult(List<Integer> winningNumbers, int bonus) {
        ListValidator.validateWinningNumbers(winningNumbers, bonus);
        return processTickets(winningNumbers, bonus);
    }

    public Result processTickets(List<Integer> winningNumbers, int bonus) {
        Result result = new Result();
        for (Lotto ticket : tickets) {
            result.add(ticket.compare(winningNumbers, bonus));
        }
        return result;
    }

    public List<String> convertTicketsToString() {
        return tickets
                .stream()
                .map(Lotto::toString)
                .collect(Collectors.toList());
    }
}
