import model.LottoGame;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    private LottoGame lottoGame;
    private int money;
    private int manualCount;
    private int autoCount;

    @Before
    public void setUp() throws Exception {
        money = 10000;
        manualCount = 2;
        autoCount = 8;
        lottoGame = new LottoGame(money, manualCount);
    }

    @Test
    public void buyManualTicketsTest() {
        List<String> manualBallsList = new ArrayList<>();
        manualBallsList.add("1, 2, 3, 4, 5, 6");
        manualBallsList.add("7, 8, 9, 10, 11, 12");
        lottoGame.buyManualTickets(manualBallsList);

        assertThat(lottoGame.getLottoList().size()).isEqualTo(manualBallsList.size());
    }

    @Test
    public void buyAutoTickets_autoCount만큼_티켓구매() {
        lottoGame.buyAutoTickets();
        assertThat(lottoGame.getLottoList().size()).isEqualTo(autoCount);
    }
}
