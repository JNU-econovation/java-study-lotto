import model.Result;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
public class ResultTest {
    @Test
    public void 당첨번호입력확인(){
        Result result = new Result("1, 2, 3, 4, 5, 6");
        assertEquals(1, result.resultDTO().getWinningNumbers().get(0));
    }
}
