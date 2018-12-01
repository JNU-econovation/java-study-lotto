import model.LottoGame;
import model.LottoNo;
import model.Rank;
import model.Result;
import org.junit.Before;
import org.junit.Test;
import utils.ManualTicketGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    private Result result;
    private LottoGame lottoGame;
    private int money;
    private int manualCount;
    private int bonusBall;


    @Before
    public void setUp() throws Exception {
        money = 2000;
        manualCount = 2;
        bonusBall = 7;
        lottoGame = new LottoGame(money, manualCount);

        List<String> manualBallsList = new ArrayList<>();
        manualBallsList.add("1, 2, 3, 4, 5, 6");
        manualBallsList.add("3, 4, 5, 6, 7, 8");

        lottoGame.buyManualTickets(manualBallsList);
        lottoGame.buyAutoTickets();
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        result = new Result(winningNumbers, bonusBall, lottoGame);
    }

    @Test
    public void initWinStatisticsTest() {
        Map<Rank, Integer> winStatistics = result.toResultDTO().getWinStatistics();
        assertThat(winStatistics.size()).isEqualTo(6);
    }

    @Test
    public void isMatchBonus_True() {
        List<LottoNo> ticket = ManualTicketGenerator.issue("1, 2, 3, 4, 5, 7");
        assertThat(result.isMatchBonus(ticket)).isTrue();
    }

    @Test
    public void isMatchBonus_False() {
        List<LottoNo> ticket = ManualTicketGenerator.issue("1, 2, 3, 4, 5, 6");
        assertThat(result.isMatchBonus(ticket)).isFalse();
    }

    @Test
    public void updateWinStatisticsTest() {
        Map<Rank, Integer> winStatistics = result.toResultDTO().getWinStatistics();
        assertThat(winStatistics.get(Rank.FIRST)).isEqualTo(1);
        assertThat(winStatistics.get(Rank.SECOND)).isEqualTo(0);
        assertThat(winStatistics.get(Rank.FOURTH)).isEqualTo(1);
    }

    @Test
    public void getMatchCount_일치개수반환() {
        List<LottoNo> ticket = ManualTicketGenerator.issue("1, 2, 3, 4, 5, 6");
        assertThat(result.getMatchCount(ticket)).isEqualTo(6);
    }

    @Test
    public void getProfit() {
        double totalWinningMoney = Rank.FIRST.getWinningMoney() + Rank.FOURTH.getWinningMoney();
        double profit = totalWinningMoney / money * 100;
        assertThat(result.getProfit()).isEqualTo(profit);
    }
}
