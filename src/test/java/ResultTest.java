import model.LottoMachine;
import model.Result;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ResultTest {
    @Test
    public void 당첨번호입력확인() {
        Result result = new Result("1, 2, 3, 4, 5, 6");
        assertEquals(1, result.resultDTO().getWinningNumbers().get(0));
    }

    @Test
    public void 당첨번호확인(){
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.buyLotto(1000);
        Result result = new Result("0, 0, 0, 0, 0, 0");
        result.getMatchingCount(lottoMachine.lottoDTO().getLottos());
        assertEquals(0, result.resultDTO().getMatchingCount());
    }
}
