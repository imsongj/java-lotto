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

    public String readLottoNumbersInput() {
        outputView.printMessage(GameMessage.ASK_LOTTO_NUMBER);
        return Console.readLine();
    }
}
