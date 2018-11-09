package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class LottoTest {
    @Test
    public void 로또객체에6개숫자리스트가들어가는지Test() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            lottoNumbers.add(i);
        }
        assertEquals(6, new Lotto(lottoNumbers).getLottoNumbers().size());
    }
}
