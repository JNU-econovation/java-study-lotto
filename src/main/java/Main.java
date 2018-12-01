import model.LottoGame;
import model.LottoResult;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args){
        LottoGame lottoGame = new LottoGame(InputView.inputMoney());
        lottoGame.buyManualLottoTicket(InputView.inputNumberOfManualTicket());
        ResultView.printTicket(lottoGame.toLottoTicketDTO());

        LottoResult lottoResult = new LottoResult(InputView.inputWinNumber());
        ResultView.printResult(lottoResult.calculateResult(lottoGame.toLottoTicketDTO()));

    }
}
