package lotto;

import lotto.domain.LottoApplication;
import lotto.dto.LottoListDTO;
import lotto.dto.WinningStatisticDTO;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        LottoApplication lottoApplication = new LottoApplication();
        LottoListDTO lottoList = lottoApplication.buyLotto(InputView.inputPurchaseAmount());
        ResultView.printLottoList(lottoList.getLottoList());

        WinningStatisticDTO winningStatisticDTO = lottoApplication.checkWinning(InputView.inputWinningLotto());
        ResultView.printWinningStatistic(winningStatisticDTO);
    }
}
