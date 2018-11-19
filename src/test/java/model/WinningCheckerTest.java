package model;

import dto.WinningCheckerDTO;
import org.junit.Test;
import util.Converter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WinningCheckerTest {
    private WinningChecker winningChecker = new WinningChecker();

    @Test
    public void 입력된당첨번호분리Test() {
        String input = "1, 2, 3, 4, 5, 6";
        assertEquals(1, (int) Converter.splitNumbers(input).get(0));
        assertEquals(2, (int) Converter.splitNumbers(input).get(1));
        assertEquals(3, (int) Converter.splitNumbers(input).get(2));
        assertEquals(4, (int) Converter.splitNumbers(input).get(3));
        assertEquals(5, (int) Converter.splitNumbers(input).get(4));
        assertEquals(6, (int) Converter.splitNumbers(input).get(5));
    }

    @Test
    public void 당첨번호로로또조회Test() {
        List<LottoNo> lottoNumbers = new ArrayList();
        lottoNumbers.add(new LottoNo(3));
        lottoNumbers.add(new LottoNo(6));
        lottoNumbers.add(new LottoNo(9));
        lottoNumbers.add(new LottoNo(12));
        lottoNumbers.add(new LottoNo(15));
        lottoNumbers.add(new LottoNo(18));

        List<Lotto> lotto = new ArrayList<>();
        lotto.add(new Lotto(lottoNumbers));

        List<LottoNo> winningNumbers = new ArrayList();
        for (int i = 1; i < 7; i++) {
            winningNumbers.add(new LottoNo(i));
        }
        int bonusNumber = 9;

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoList lottoList = new LottoList(lotto, 1000);
        winningChecker.checkResult(lottoList.toLottoListDTO(), winningLotto.toWinningLottoDTO());
        WinningCheckerDTO winningCheckerDTO = winningChecker.toWinningCheckerDTO();
        assertEquals(1, (int) winningCheckerDTO.getWinningList().get("FIFTH"));
    }

    @Test
    public void 수익률Test() {
        List<LottoNo> lottoNumbers = new ArrayList();
        lottoNumbers.add(new LottoNo(1));
        lottoNumbers.add(new LottoNo(2));
        lottoNumbers.add(new LottoNo(3));
        lottoNumbers.add(new LottoNo(7));
        lottoNumbers.add(new LottoNo(8));
        lottoNumbers.add(new LottoNo(9));

        List<Lotto> lotto = new ArrayList<>();
        lotto.add(new Lotto(lottoNumbers));

        List<LottoNo> winningNumbers = new ArrayList();
        for (int i = 1; i <= 6; i++) {
            winningNumbers.add(new LottoNo(i));
        }
        int bonusNumber = 10;
        int money = 1000;

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoList lottoList = new LottoList(lotto, money);
        winningChecker.checkResult(lottoList.toLottoListDTO(), winningLotto.toWinningLottoDTO());
        WinningCheckerDTO winningCheckerDTO = winningChecker.toWinningCheckerDTO();
        assertEquals(500, (int) winningCheckerDTO.getProfitRate());
    }
}
