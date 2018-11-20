import model.Lotto;
import model.LottoMachine;
import model.Rank;
import model.Result;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ResultTest {


    List<String> manualLottos = new ArrayList<>();
    @Test
    public void 당첨번호입력확인() {
        manualLottos.add("1,2,3,4,5,6");
        LottoMachine lottoMachine = new LottoMachine(1000, manualLottos);
        Result result = new Result("1, 2, 3, 4, 5, 6", 7, lottoMachine );
        assertEquals(1, result.resultDTO().getWinningInformation().get(Rank.FIRST).intValue());
    }

    @Test
    public void 보너스볼확인(){
        manualLottos.add("2, 3, 4, 5, 6, 7");
        LottoMachine lottoMachine = new LottoMachine(1000, manualLottos);
        Result result = new Result("1, 2, 3, 4, 5, 6", 7, lottoMachine);
        assertEquals(1, result.resultDTO().getWinningInformation().get(Rank.SECOND).intValue());
    }

    @Test
    public void 수익률계산(){
        manualLottos.add("2, 3, 4, 5, 6, 7");
        LottoMachine lottoMachine = new LottoMachine(1000, manualLottos);
        Result result = new Result("1, 2, 3, 4, 5, 6", 7, lottoMachine);
        assertEquals(30000.0, result.resultDTO().getProfit());
    }
}
