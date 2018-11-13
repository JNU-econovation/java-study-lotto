import model.LottoMachine;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    public void 로또기계번호생성() {
        assertEquals(6, lottoMachine.generateLotto().size());
    }

    @Test
    public void 로또가게에서금액만큼로또구매() {
        lottoMachine.buyLotto(2000);
        assertEquals(2, lottoMachine.lottoDTO().getLottos().size());
    }

    @Test
    public void 로또DTO테스트() {
        lottoMachine.buyLotto(3000);
        assertEquals(3, lottoMachine.lottoDTO().getLottos().size());
    }
}
