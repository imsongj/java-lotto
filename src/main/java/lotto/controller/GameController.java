package lotto.controller;

import lotto.model.LottoGame;
import lotto.model.LottoStatistic;
import lotto.model.StringValidator;
import lotto.view.ErrorMessage;
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
        LottoGame lottoGame = new LottoGame();
        try {
            lottoGame.buyLotto(getMoney());
            outputView.printLottoTickets(lottoGame.convertTicketsToString());
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }

    public long getMoney() {
        String input = inputView.readMoneyInput();
        try {
            StringValidator.validateMoney(input);
            return Long.parseLong(input);
        } catch (IllegalArgumentException exception) {
            outputView.printError(ErrorMessage.INVALID_MONEY, LottoStatistic.PRICE.getValue());
            throw exception;
        }
    }
}
