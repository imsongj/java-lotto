package lotto.view;

public enum ErrorMessage {
    INVALID_MONEY("[ERROR] 구입 금액은 %,d원으로 나누어 떨어지는 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
