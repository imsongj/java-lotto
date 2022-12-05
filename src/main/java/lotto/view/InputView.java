package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final OutputView outputView;

    public InputView() {
        outputView = new OutputView();
    }

    public String readMoneyInput() {
        outputView.printMessage(GameMessage.ASK_MONEY);
        return Console.readLine();
    }

    public String readWinningNumbersInput() {
        outputView.printMessage(GameMessage.ASK_WINNING_NUMBER);
        return Console.readLine();
    }

    public String readBonusInput() {
        outputView.printMessage(GameMessage.ASK_BONUS);
        return Console.readLine();
    }
}
