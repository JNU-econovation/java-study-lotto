package model;

import org.junit.Test;
import util.StringConverter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WinningCheckerTest {
    private WinningChecker winningChecker = new WinningChecker();

    @Test
    public void 입력된당첨번호분리Test() {
        assertEquals(6, StringConverter.splitNumbers("1, 2, 3, 4, 5, 6").length);
    }

    @Test
    public void 당첨번호로로또조회Test() {
        List<Integer> lottoNumbers = new ArrayList();
        lottoNumbers.add(3);
        lottoNumbers.add(6);
        lottoNumbers.add(9);
        lottoNumbers.add(12);
        lottoNumbers.add(15);
        lottoNumbers.add(18);

        int[] winningNumbers = {1, 2, 3, 4, 5, 6};
        assertEquals(2, winningChecker.checkCorrectCounts(new Lotto(lottoNumbers), winningNumbers));
    }

    @Test
    public void 수익률계산Test() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        List<Integer> lottoNumbers = new ArrayList();
        lottoNumbers.add(1);
        lottoNumbers.add(3);
        lottoNumbers.add(6);
        lottoNumbers.add(12);
        lottoNumbers.add(15);
        lottoNumbers.add(18);

        List lottoList = new ArrayList();
        lottoList.add(new Lotto(lottoNumbers));

        winningChecker.checkWinningLotto(lottoList, winningNumbers, 1000);
        assertEquals(500, (int) winningChecker.toLottoCheckerDTO().getProfitRate());
    }


}
