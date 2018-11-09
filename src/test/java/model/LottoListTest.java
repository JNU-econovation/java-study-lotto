package model;

import jdk.nashorn.internal.ir.LiteralNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LottoListTest {
    @Test
    public void 로또리스트에로또가들어가는지Test() {
        List lottoNumbers = new ArrayList();
        for (int i = 1; i < 7; i++) {
            lottoNumbers.add(i);
        }
        Lotto lotto = new Lotto(lottoNumbers);
        LottoList lottoList = new LottoList();
        lottoList.addLottoToList(lotto);

        assertEquals(true, lottoList.toLottoListDTO().getLottoList().get(0) instanceof Lotto);
    }
}
