import model.LottoGame;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    private LottoGame lottoGame;
    private int count = 5;

    @Before
    public void setUp() throws Exception {
        lottoGame = new LottoGame(count);
    }

    @Test
    public void buyTickets_count만큼_복권구매() {
        int size = lottoGame.buyTickets(count).size();
        assertThat(size).isEqualTo(count);
    }
}
