package lotto.view;

public enum GameMessage {
    ASK_MONEY("구입금액을 입력해 주세요."),
    PURCHASE("%n%,d개를 구매했습니다."),
    ASK_WINNING_NUMBER("%n당첨 번호를 입력해 주세요."),
    ASK_BONUS("%n보너스 번호를 입력해 주세요."),
    RESULT_HEADER("\n당첨 통계\n---");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
