import model.LottoNo;
import org.junit.Test;

public class LottoNoTest {
    LottoNo lottoNo;

    @Test(expected = RuntimeException.class)
    public void LottoNo_1과_45사이의_값이_아닐경우_예외처리() {
        lottoNo = new LottoNo(46);
    }
}
