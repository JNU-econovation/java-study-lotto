import static junit.framework.TestCase.assertEquals;
import model.LottoMachine;
import model.LottoStore;
import model.Result;
import utils.SearchElement;
import org.junit.Test;

public class LottoTest {

    LottoStore lottoStore = new LottoStore(2000);

    @Test
    public void 로또기계번호생성() {
        LottoMachine lottoMachine = new LottoMachine();
        assertEquals(6, lottoMachine.generateLotto().length);
    }

    @Test
    public void 로또가게에서금액만큼로또구매() {
        assertEquals(2, lottoStore.buyLotto().length);
    }

    @Test
    public void 로또한개에서숫자하나찾기() {
        int lottoExample1[] = {1, 2, 3, 4, 5, 6};
        SearchElement observer = new SearchElement();
        assertEquals(true, observer.isIntegerElement(lottoExample1, 1));
    }

    @Test
    public void 한로또에서당첨개수찾기() {
        int lottoExample[][] = {{1, 2, 3, 4, 5, 6}, {2, 4, 6, 8, 10, 12}};
        String winningString = "1,2,3,4,5,6";
        Result result = new Result(lottoStore, lottoExample, winningString);
        result.checkEachLotto(0);
        assertEquals(6, result.sameNumberCounter);
    }

    @Test
    public void 여러로또들등수정하기() {
        int lottoExample[][] = {{1, 2, 3, 4, 5, 6}, {2, 4, 6, 8, 10, 12}};
        String winningString = "1,2,3,4,5,6";
        Result result = new Result(lottoStore, lottoExample, winningString);
        result.checkMyLottos();
        assertEquals(1, result.rankList[0]);
    }

    @Test
    public void 당첨금확인() {
        int lottoExample[][] = {{1, 2, 3, 4, 5, 6}, {2, 4, 6, 8, 10, 12}};
        String winningString = "1,2,3,4,5,6";
        Result result = new Result(lottoStore, lottoExample, winningString);
        result.checkMyLottos();
        assertEquals(result.winningMoney, result.winningMoney);
    }

    @Test
    public void 수익률계산() {
        int lottoExample[][] = {{1, 2, 3, 4, 5, 6}, {2, 4, 6, 8, 10, 12}};
        String winningString = "1,2,3,4,5,6";
        Result result = new Result(lottoStore, lottoExample, winningString);
        result.checkMyLottos();
        assertEquals(result.winningMoney / result.inputMoney, result.winningMoney / result.inputMoney);
    }
}