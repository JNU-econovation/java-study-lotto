import model.LottoGame;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args){
        LottoGame lottoGame = new LottoGame(InputView.setMoney());
        lottoGame.buyAutoLottoTicket();
        ResultView.printTicket(lottoGame.toAutoLottoDTO());
        lottoGame.setNumberOfWinner(InputView.setWinner());
        ResultView.printStatistics(lottoGame.toResultDto());
    }
}
