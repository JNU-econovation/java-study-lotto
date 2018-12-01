package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class LottoMakerTest {
    private static LottoMaker lottoMaker = new LottoMaker();

    @Test
    public void 로또에6개숫자가들어가는지TEST() {
        assertEquals(6, lottoMaker.makeLotto().getLottoNumbers().size());
    }

    @Test
    public void 로또숫자가45이하인숫자인지TEST() {
        for (int i = 0; i < 6; i++) {
            assertEquals(lottoMaker.makeLotto().getLottoNumbers().get(i).getLottoNo() < 46, true);
        }
    }

    @Test
    public void 금액만큼LottoList에Lotto가생성되는지TEST() {
        Lotto lotto = lottoMaker.makeLotto();
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);

        assertEquals(14, lottoMaker.makeLottoList(14000, lottoList).toLottoListDTO().getLottoList().size());
    }
}
