import model.AutoLotto;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args){
        AutoLotto autoLotto = new AutoLotto();
        AutoLotto.setInputMoney(InputView.setMoney());
        AutoLotto.buyAutoLottoTicket();
        ResultView.printTicket(autoLotto.toAutoLottoDTO());
        AutoLotto.setNumberOfWinner(InputView.setWinner());
        AutoLotto.countMatchNum();
        ResultView.printStatistics(autoLotto.toResultDto());
    }
}
