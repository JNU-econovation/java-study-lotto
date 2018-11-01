package app;

import model.LottoGame;
import model.Result;
import view.InputView;
import view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.readMoney());
        Result result = new Result(InputView.readWinningNumbers(), lottoGame.toLottoDTO());
        result.update();
        ResultView.printResult(result.toResultDTO());
    }
}
