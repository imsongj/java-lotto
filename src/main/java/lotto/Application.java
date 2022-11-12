package lotto;

import lotto.constant.GameMessage;
import lotto.domain.Machine;
import lotto.domain.Organizer;
import lotto.domain.Player;
import lotto.exception.ExceptionHandler;
import lotto.userinterface.Input;

public class Application {
    public static void main(String[] args) {
        String initialMoneyInput = Input.getInputWithMessage(GameMessage.ASK_FOR_INITIAL_MONEY.getMessage());
        ExceptionHandler.isStringNumeric(initialMoneyInput);

        Player player = new Player(Long.parseLong(initialMoneyInput));
        Machine lottoMachine = new Machine();
        player.buyLottoTickets(lottoMachine);
        player.displayLottoTickets();

        String winningNumberInput = Input.getInputWithMessage(GameMessage.ASK_FOR_WINNING_NUMBERS.getMessage());
        String bonusNumberInput = Input.getInputWithMessage(GameMessage.ASK_FOR_BONUS_NUMBER.getMessage());
        Organizer organizer = new Organizer(winningNumberInput, bonusNumberInput);
    }
}
