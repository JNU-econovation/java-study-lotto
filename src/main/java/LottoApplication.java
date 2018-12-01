import dto.LottoListDTO;
import dto.WinningLottoDTO;
import model.*;
import util.Converter;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoApplication {
    private static LottoMaker lottoMaker = new LottoMaker();
    private static WinningChecker winningChecker = new WinningChecker();

    public static void main(String[] args) {
        int money = InputView.inputPayment();
        int manualLottoCount = InputView.inputManualLotto();
        List<Lotto> manualLottoList = Converter.splitNumbers(InputView.inputManualLottoNumbers(manualLottoCount));

        LottoListDTO lottoListDTO = lottoMaker.makeLottoList(money, manualLottoList).toLottoListDTO();
        OutputView.getPurchaseResult(lottoListDTO, manualLottoCount);

        List<Integer> winningNumbers = Converter.splitNumbers(InputView.inputWinningNumbers());
        LottoNo bonusNumber = new LottoNo(InputView.inputBonusNumber());

        WinningLottoDTO winningLottoDTO = new WinningLotto(Converter.convertIntegerToLottoNo(winningNumbers), bonusNumber.getLottoNo()).toWinningLottoDTO();
        winningChecker.checkResult(lottoListDTO, winningLottoDTO);
        OutputView.getWinningResult(winningChecker.toWinningCheckerDTO());
    }
}
