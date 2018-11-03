import dto.LottoListDTO;
import model.LottoMaker;
import model.WinningChecker;
import view.InputView;
import view.OutputView;

public class LottoApplication {
    private static LottoMaker lottoMaker = new LottoMaker();
    private static WinningChecker lottoChecker = new WinningChecker();

    public static void main(String[] args) {
        int money = InputView.inputPayment();
        LottoListDTO lottoList = lottoMaker.makeLottoList(money).toLottoListDTO();
        OutputView.getPurchaseResult(lottoList);

        String winningNumbers = InputView.inputWinningNumbers();
        lottoChecker.checkWinningLotto(lottoList.getLottoList(), winningNumbers, money);
        OutputView.getWinningResult(lottoChecker.toLottoCheckerDTO());
    }
}
