package lotto.view;

public enum GameMessage {
    ASK_MONEY("구입금액을 입력해 주세요."),
    PURCHASE("%,d개를 구매했습니다.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
