package model;

import org.junit.Test;
import util.StringConverter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WinningNumbersCheckerTest {
    @Test
    public void 입력된당첨번호분리Test() {
        assertEquals(6, StringConverter.splitNumbers("1, 2, 3, 4, 5, 6").length);
    }

    @Test
    public void 당첨번호로로또조회Test() {
        WinningChecker checker = new WinningChecker();
        int[] winningNumbers = {1, 2, 3, 4, 5, 6};
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(5);
        lottoNumbers.add(9);
        lottoNumbers.add(15);
        lottoNumbers.add(35);
        lottoNumbers.add(45);
        assertEquals(2, checker.checkCorrectCounts(new Lotto(lottoNumbers), winningNumbers));
    }
}
