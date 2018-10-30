import model.Lotto;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto lotto;
    private int count = 5;

    @Before
    public void setUp() throws Exception {
        lotto = new Lotto(count);
    }

    @Test
    public void buyTickets_count만큼_복권구매() {
        int size = lotto.buyTickets(count).size();
        assertThat(size).isEqualTo(count);
    }
}
