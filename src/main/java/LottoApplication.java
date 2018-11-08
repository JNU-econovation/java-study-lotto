import dto.LottoListDTO;
import model.LottoMaker;
import model.WinningChecker;
import view.InputView;
import view.OutputView;

public class LottoApplication {
    private static LottoMaker lottoMaker = new LottoMaker();
    private static WinningChecker winningChecker = new WinningChecker();

    public static void main(String[] args) {
        int money = InputView.inputPayment();
        LottoListDTO lottoListDTO = lottoMaker.makeLottoList(money).toLottoListDTO();
        OutputView.getPurchaseResult(lottoListDTO);

        winningChecker.checkWinningLotto(lottoListDTO.getLottoList(), InputView.inputWinningNumbers(), money);
        OutputView.getWinningResult(winningChecker.toLottoCheckerDTO());
    }
}
