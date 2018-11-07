package lotto;

import lotto.domain.LottoApplication;
import org.junit.Before;
import org.junit.Test;

public class LottoApplicationTest {

    private LottoApplication lottoApplication;

    @Before
    public void setup() {
        lottoApplication = new LottoApplication(14000);
    }

    @Test
    public void startApplicationTest() {
        lottoApplication.enterPurchaseMoney(14);

    }
}
