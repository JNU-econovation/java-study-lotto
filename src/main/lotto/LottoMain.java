package lotto;

import lotto.domain.LottoApplication;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        LottoApplication lottoApplication = new LottoApplication();
        ResultView.printLottoList(lottoApplication.enterPurchaseMoney(InputView.inputPurchaseAmount()));

    }
}
