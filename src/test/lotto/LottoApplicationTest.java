package lotto;

import lotto.domain.LottoApplication;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LottoApplicationTest {
    private LottoApplication lotto;

    @Before
    public void setup() {
        lotto = new LottoApplication();
    }

    @Test
    public void buyLottoTest_로또개수() {
        assertEquals(14, lotto.buyLotto(14000).getLottoList().size());
    }

    @Test
    public void generateLottoTest_생성된로또크기() {
        assertEquals(6, lotto.generateLotto().toLottoDTO().getLottoNumbers().size());
    }
}
