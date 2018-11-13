package app;

import model.LottoGame;
import model.Result;
import view.InputView;
import view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        int money = InputView.readMoney();
        int manualCount = InputView.readManualCount();
        LottoGame lottoGame = new LottoGame(money, manualCount);
        Result result;

        lottoGame.buyManualTickets(InputView.readManualBalls(manualCount));
        lottoGame.buyAutoTickets();
        ResultView.printTickets(lottoGame.toLottoGameDTO());
        result = new Result(InputView.readWinningNumbers(), InputView.readBonusBall(), lottoGame);
        ResultView.printResult(result.toResultDTO());
    }
}