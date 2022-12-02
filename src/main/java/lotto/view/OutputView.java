package lotto.view;

import java.util.List;

public class OutputView {
    private static final String NEW_LINE = "%n";

    public void printMessage(GameMessage gameMessage) {
        System.out.println(gameMessage.getMessage());
    }

    public void printMessage(GameMessage gameMessage, int formatNumber) {
        System.out.printf(gameMessage.getMessage() + NEW_LINE, formatNumber);
    }

    public void printError(ErrorMessage errorMessage) {
        System.out.println(errorMessage.getMessage());
    }

    public void printError(ErrorMessage errorMessage, int formatNumber) {
        System.out.printf(errorMessage.getMessage() + NEW_LINE, formatNumber);
    }

    public void printLottoTickets(List<String> tickets) {
        printEmptyLine();
        printMessage(GameMessage.PURCHASE, tickets.size());
        for (String ticket : tickets) {
            System.out.println(ticket);
        }
    }

    public void printEmptyLine() {
        System.out.printf(NEW_LINE);
    }
}
