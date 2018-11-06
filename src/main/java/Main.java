import model.LottoStore;
import model.Result;
import view.InputView;
import view.ResultView;

public class Main{
    public static void main(String [] args){
        InputView inputView = new InputView();
        LottoStore lottoStore = new LottoStore(inputView.purchaseLotto());
        Result result = new Result(lottoStore, lottoStore.buyLotto(), inputView.winnerNumber());
        result.checkMyLottos();
        ResultView resultView = new ResultView(result);
        resultView.printResult();
    }
}