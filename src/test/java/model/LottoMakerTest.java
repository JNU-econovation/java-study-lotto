package model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class LottoMakerTest {
    private static LottoMaker lottomaker = new LottoMaker();

    @Test
    public void 로또에6개숫자가들어가는지TEST() {
        assertEquals(6, lottomaker.makeLotto().getLottoNumbers().length);
    }

    @Test
    public void 로또숫자가45이하인숫자인지TEST() {
        for (int i = 0; i < 6; i++) {
            assertEquals(lottomaker.makeLotto().getLottoNumbers()[i] < 46, true);
        }
    }

    @Test
    public void 금액만큼LottoList에Lotto가생성되는지TEST() {
        assertEquals(14, lottomaker.makeLottoList(14000).toLottoListDTO().getLottoList().size());
    }
}
