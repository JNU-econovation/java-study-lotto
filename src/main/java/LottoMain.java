import model.LottoGame;
import model.WinningLotto;
import view.InputView;
import view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        OutputView.printNumberOfLottos(lottoGame.insertMoney(InputView.putPrice()));
        OutputView.drawLottos(lottoGame.generateLottos());

        WinningLotto winningLotto = new WinningLotto();
        winningLotto.setWinNumber(InputView.putWinNumber());

        OutputView.showStatistics(lottoGame.scoreStatistics(winningLotto));
        OutputView.printEarningRate(lottoGame.calculateEarningRate(winningLotto));
    }
}
