import model.Lotto;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto lotto;

    @Before
    public void setUp() throws Exception {
        lotto = new Lotto();
    }

    @Test
    public void getAllBalls_모든_로또공_반환() {
        int size = lotto.getAllBalls().size();
        assertThat(size).isEqualTo(45);
    }

    @Test
    public void issue_로또발급() {
        int size = lotto.issue().size();
        assertThat(size).isEqualTo(6);
    }
}
