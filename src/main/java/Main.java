import model.LottoMachine;
import model.Result;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.buyLotto(inputView.purchaseLotto());
        resultView.printLottos(lottoMachine.lottoDTO());
        Result result = new Result(resultView.inputWinningNumbers(), lottoMachine);
        resultView.printProfit(result.resultDTO());
    }
}