package app;

import model.Lotto;
import model.Result;
import view.InputView;
import view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        Lotto lotto = new Lotto(InputView.putMoney());
        Result result = new Result(InputView.putWinningNumbers(), lotto.toLottoDTO());
        result.update();
        ResultView.printResult(result.toResultDTO());
    }
}
