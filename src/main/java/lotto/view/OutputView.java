package lotto.view;

public class OutputView {
    public void printMessage(GameMessage gameMessage) {
        System.out.println(gameMessage.getMessage());
    }

    public void printError(ErrorMessage errorMessage) {
        System.out.println(errorMessage.getMessage());
    }

    public void printError(ErrorMessage errorMessage, int formatNumber) {
        System.out.printf(errorMessage.getMessage() + "%n", formatNumber);
    }
}
