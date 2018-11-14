import model.Lotto;
import model.LottoMachine;
import model.Result;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ResultTest {

    Result result = new Result("0, 0, 0, 0, 0, 0");

    @Test
    public void 당첨번호입력확인() {
        Result result = new Result("1, 2, 3, 4, 5, 6");
        assertEquals(1, result.resultDTO().getWinningNumbers().get(0));
    }

    @Test
    public void 모든당첨번호확인() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.buyLotto(1000);
        result.getMatchingCount(lottoMachine.lottoDTO().getLottos());
        assertEquals(0, result.resultDTO().getMatchingCounts()[1]);
    }

    @Test
    public void 각로또당첨번호확인() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.buyLotto(1000);
        assertEquals(0, result.getEachMatchingCount(lottoMachine.lottoDTO().getLottos().get(0), result.resultDTO().getWinningNumbers()));
    }

    @Test
    public void 포함되는원소확인() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.buyLotto(1000);
        assertEquals(0, result.isMatched(lottoMachine.lottoDTO().getLottos().get(0), 0));
    }

    @Test
    public void 수익률계산() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.buyLotto(1000);
        assertEquals(0.0, result.resultDTO().getProfit());
    }
}
