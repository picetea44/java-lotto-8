package lotto.random;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class RandomsNumberSource implements NumberSource {
    @Override
    public List<Integer> drawSix() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}