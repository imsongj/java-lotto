package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.model.LottoGame;
import lotto.model.LottoStatistic;
import lotto.model.Result;
import lotto.model.StringValidator;
import lotto.view.ErrorMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private static final String DELIMITER = ",";

    private final InputView inputView;
    private final OutputView outputView;


    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        LottoGame lottoGame = new LottoGame();
        if (buyLotto(lottoGame)) {
            calculateResult(lottoGame);
        }

    }

    public boolean buyLotto(LottoGame lottoGame) {
        try {
            lottoGame.buyLotto(getMoney());
            outputView.printLottoTickets(lottoGame.convertTicketsToString());
            return true;
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            outputView.printMoneyError(ErrorMessage.INVALID_MONEY, LottoStatistic.PRICE.getValue());
            return false;
        }
    }

    public void calculateResult(LottoGame lottoGame) {
        try {
            Result result = lottoGame.getResult(getWinningNumbers(), getBonus());
            outputView.printResult(result);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            outputView.printLottoNumberError(ErrorMessage.INVALID_LOTTO_NUMBER,
                    LottoStatistic.MIN_NUMBER.getValue(), LottoStatistic.MAX_NUMBER.getValue());
        }
    }

    public long getMoney() {
        String input = inputView.readMoneyInput();
        StringValidator.validateNumeric(input);
        StringValidator.validateDivisible(input, LottoStatistic.PRICE.getValue());
        return Long.parseLong(input);
    }

    public List<Integer> getWinningNumbers() {
        String input = inputView.readWinningNumbersInput();
        StringValidator.validateIntegerList(input, DELIMITER);
        return Stream.of(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getBonus() {
        String input = inputView.readBonusInput();
        StringValidator.validateNumeric(input);
        StringValidator.validateInteger(input);
        return Integer.parseInt(input);
    }
}
