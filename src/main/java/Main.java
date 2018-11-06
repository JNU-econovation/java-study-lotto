import model.LottoMachine;
import model.LottoStore;
import model.Result;
import view.InputView;
import view.LottoView;
import view.ResultView;

public class Main{
    public static void main(String [] args){
        InputView inputView = new InputView();
        LottoStore lottoStore = new LottoStore(inputView.purchaseLotto());
        Result result = new Result(inputView, lottoStore, lottoStore.buyLotto());
        result.checkMyLottos();
        ResultView resultView = new ResultView(result);
        resultView.printResult();
    }
}