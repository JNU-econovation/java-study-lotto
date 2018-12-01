
import model.Lotto;
import model.LottoMachine;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class LottoTest {
    List<String> manualLottos = new ArrayList<>();

    @Test
    public void 로또생성확인() {
        LottoMachine lottoMachine = new LottoMachine(1000, manualLottos);
        assertEquals(6, lottoMachine.lottoDTO()
                .getLottos().get(0)
                .getLottoNumbers().size());
    }

    @Test
    public void 수동로또생성확인(){
        manualLottos.add("1, 2, 3, 4, 5, 6");
        LottoMachine lottoMachine = new LottoMachine(1000, manualLottos);
        assertEquals(6, lottoMachine.lottoDTO()
                .getLottos().get(0)
                .getLottoNumbers().size());
    }

    @Test
    public void 자동_수동_생성확인(){
        manualLottos.add("1, 2, 3, 4, 5, 6");
        LottoMachine lottoMachine = new LottoMachine(2000, manualLottos);
        assertEquals(2, lottoMachine.lottoDTO()
                .getLottos().size());
    }
}
