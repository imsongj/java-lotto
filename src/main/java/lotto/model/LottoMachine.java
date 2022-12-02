package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoMachine {
    public static Lotto createLotto() {
        return new Lotto(generateLottoNumbers());
    }

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoStatistic.MIN_NUMBER.getValue(),
                LottoStatistic.MAX_NUMBER.getValue(), LottoStatistic.SIZE.getValue());
    }
}
