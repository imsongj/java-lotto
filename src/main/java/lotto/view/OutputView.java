package lotto.view;

import java.util.List;
import java.util.Map;

import lotto.model.Prize;
import lotto.model.Result;

public class OutputView {
    private static final String NEW_LINE = "%n";
    private static final String PRIZE_RESULT = "%d개 일치%s (%,d원) - %d개";
    private static final String BONUS = ", 보너스 볼 일치";
    private static final String PROFIT_RATE = "총 수익률은 %,.1f%%입니다.";

    public void printMessage(GameMessage gameMessage) {
        System.out.printf(gameMessage.getMessage() + NEW_LINE);
    }

    public void printMessage(GameMessage gameMessage, int formatNumber) {
        System.out.printf(gameMessage.getMessage() + NEW_LINE, formatNumber);
    }

    public void printMoneyError(ErrorMessage errorMessage, int price) {
        System.out.printf(errorMessage.getMessage() + NEW_LINE, price);
    }

    public void printLottoNumberError(ErrorMessage errorMessage, int min, int max) {
        System.out.printf(errorMessage.getMessage() + NEW_LINE, min, max);
    }

    public void printLottoTickets(List<String> tickets) {
        printMessage(GameMessage.PURCHASE, tickets.size());
        for (String ticket : tickets) {
            System.out.println(ticket);
        }
    }

    public void printResult(Result result) {
        System.out.println(GameMessage.RESULT_HEADER.getMessage());
        printPrizeResult(result);
        System.out.printf(PROFIT_RATE + NEW_LINE, result.getProfitRate());
    }

    public void printPrizeResult(Result result) {
        for (Map.Entry<Prize, Integer> entry : result.getPrizeResult().entrySet()) {
            if (entry.getKey().isNothing()) {
                continue;
            }
            System.out.println(convertPrizeToString(entry.getKey(), entry.getValue()));
        }
    }

    public String convertPrizeToString(Prize prize, int count) {
        return String.format(PRIZE_RESULT,
                prize.getMatchCount(), getBonusString(prize.getMatchBonus()), prize.getPrize(), count);
    }

    public String getBonusString(boolean bonus) {
        if (bonus) {
            return BONUS;
        }
        return "";
    }
}
