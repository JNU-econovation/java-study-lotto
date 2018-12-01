import model.LottoMachine;
import model.Result;
import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(InputView.purchaseLotto(), InputView.manualyPurchaseLottos(InputView.manualyPurchaseLottoCount()));
        ResultView.printLottos(lottoMachine.lottoDTO());
        Result result = new Result(ResultView.inputWinningNumbers(), InputView.getBonusBall(), lottoMachine);
        ResultView.printProfit(result.resultDTO());
    }
}