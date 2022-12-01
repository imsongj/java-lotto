package lotto.controller;

import lotto.model.LottoStatistic;
import lotto.model.Validator;
import lotto.view.ErrorMessage;
import lotto.view.GameMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        try {
            getMoney();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }

    public long getMoney() {
        outputView.printMessage(GameMessage.ASK_MONEY);
        String input = inputView.readInput();
        try {
            Validator.validateMoney(input);
            return Long.parseLong(input);
        } catch (IllegalArgumentException exception) {
            outputView.printError(ErrorMessage.INVALID_MONEY, LottoStatistic.PRICE.getValue());
            throw exception;
        }
    }
}
