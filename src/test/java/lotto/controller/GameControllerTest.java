package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameControllerTest {
    @DisplayName("잘못된 로또 번호를 입력하면 예외를 발생시킨다.")
    @Test
    void throwExceptionForInvalidLottoNumber() {
        assertThat(new GameController().convertStringToList("vsvsv,a,dd,4,5"))
                .isEqualTo(List.of(1,2,3,4));
    }
}
