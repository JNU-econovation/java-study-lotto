
import model.LottoMachine;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class LottoTest {
    @Test
    public void 리스트반환(){
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.buyLotto(1000);
        assertEquals(6, lottoMachine.lottoDTO()
                .getLottos().get(0)
                .getLottoNumbers().size());
    }
}
