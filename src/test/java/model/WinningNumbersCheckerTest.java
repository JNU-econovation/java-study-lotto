package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WinningNumbersCheckerTest {
    @Test
    public void 입력된당첨번호분리Test() {
        assertEquals(6, Converter.splitNumbers("1, 2, 3, 4, 5, 6").length);
    }

    @Test
    public void 당첨번호로로또조회Test() {
        WinningChecker checker = new WinningChecker();
        int[] winningNumbers = {1, 2, 3, 4, 5, 6};
        int[] lottoNumbers = {1, 5, 9, 15, 35, 45};
        assertEquals(2, checker.checkCorrectCounts(new Lotto(lottoNumbers), winningNumbers));
    }
}
